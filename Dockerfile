FROM openjdk:11.0.11
EXPOSE 8080
ADD target/seb-project-docker.jar seb-project-docker.jar
ENTRYPOINT ["java", "-jar", "/seb-project-docker.jar"]