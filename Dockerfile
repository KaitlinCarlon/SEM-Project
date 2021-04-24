#Define docker image using latest jdk image
FROM openjdk:latest
COPY ./target/group9.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group9.jar"]