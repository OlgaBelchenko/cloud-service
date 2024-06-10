FROM openjdk:20-jdk
EXPOSE 8080
ADD ./target/cloud-service-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]