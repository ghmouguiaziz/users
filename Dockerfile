FROM openjdk:17-alpine
EXPOSE 8081
ADD target/security-0.0.1-SNAPSHOT.jar security.jar
ENTRYPOINT ["java","-jar","security.jar"]
