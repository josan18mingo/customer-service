FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/consumer-service-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]