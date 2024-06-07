FROM openjdk:17-alpine
EXPOSE 8080
COPY /target/cloud-service-0.0.1.jar app.jar
CMD ["java", "-jar", "/app.jar"]