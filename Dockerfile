FROM openjdk:latest
COPY ./target/SEM-Project-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SEM-Project-0.1.0.2-jar-with-dependencies.jar"]