# -------- Stage 1: build + test + allure report --------
FROM maven:3.9.12-eclipse-temurin-25 AS builder
WORKDIR /app

COPY pom.xml .
RUN mvn -B -q -DskipTests dependency:go-offline

COPY src ./src

# (Opcional) Si realmente necesitas Chrome dentro del contenedor para Selenide:
RUN apt-get update && apt-get install -y wget gnupg unzip curl && \
    curl -fsSL https://dl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/share/keyrings/google-linux.gpg && \
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-linux.gpg] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/*

ENV PATH="/usr/bin:$PATH"
ENV CHROME_BIN=/usr/bin/google-chrome
ENV DISPLAY=:99

# Corre pruebas + genera reporte Allure vía plugin
RUN mvn -B test allure:report

# -------- Stage 2: serve static report --------
FROM nginx:alpine AS report
COPY --from=builder /app/target/site/allure-maven-plugin/ /usr/share/nginx/html/
EXPOSE 80
