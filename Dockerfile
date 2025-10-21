FROM maven:3.9.8-eclipse-temurin-21
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

#COPY src ./src
COPY target/spring.test-0.0.1-SNAPSHOT.jar app.jar


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

CMD ["mvn", "test"]
