FROM maven:3.9.12-eclipse-temurin-25
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src

RUN apt-get update && apt-get install -y wget gnupg unzip curl && \
    curl -fsSL https://dl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/share/keyrings/google-linux.gpg && \
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-linux.gpg] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && apt-get install -y google-chrome-stable && \
    CHROME_VERSION=$(google-chrome --version | grep -oP '\d+\.\d+\.\d+') && \
    CHROMEDRIVER_VERSION=$(curl -s "https://googlechromelabs.github.io/chrome-for-testing/LATEST_RELEASE_$CHROME_VERSION") && \
    wget -q "https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/$CHROMEDRIVER_VERSION/linux64/chromedriver-linux64.zip" -O /tmp/chromedriver.zip && \
    unzip /tmp/chromedriver.zip -d /tmp && mv /tmp/chromedriver-linux64/chromedriver /usr/bin/chromedriver && chmod +x /usr/bin/chromedriver && \
    rm -rf /var/lib/apt/lists/* /tmp/*

ENV PATH="/usr/bin:$PATH"
ENV DISPLAY=:99
ENV CHROME_BIN=/usr/bin/google-chrome

# Run tests and generate Allure results data (XML/JSON files)
# The "mvn clean install" command typically runs the tests
RUN mvn clean install -DskipTests
# Then run the tests specifically to generate results
RUN mvn test

# Stage 2: Generate and serve the Allure Report
# Use a Java image as Allure requires Java to run its command line tool
FROM openjdk:25-alpine AS server

# Install curl and unzip to manage Allure CLI download
RUN apk update && apk add curl unzip bash

# Define Allure version and installation directory
ENV ALLURE_VERSION 2.27.0
ENV ALLURE_HOME /opt/allure
ENV PATH $PATH:$ALLURE_HOME/bin

# Download and install Allure commandline
RUN curl -Ls https://repo.maven.apache.org | tar xz -C /opt/
RUN mv /opt/allure-commandline-$ALLURE_VERSION /opt/allure

# Copy the generated Allure results from the builder stage
COPY --from=builder /app/target/allure-results /app/allure-results
WORKDIR /app

# Generate the HTML report into the 'allure-report' directory
RUN allure generate allure-results --clean -o allure-report

# Expose a port to view the report (e.g., port 80)
EXPOSE 80

# Command to serve the generated report, automatically opening it in a browser
# Note: "allure serve" is for local viewing, for a persistent container, a simple web server is better
CMD ["allure", "serve", "allure-results", "-p", "80"]
