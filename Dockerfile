FROM maven:3.9.6-eclipse-temurin-17
WORKDIR /app
COPY . /app
RUN mvn clean test
CMD ["cat", "target/surefire-reports/index.html"]
