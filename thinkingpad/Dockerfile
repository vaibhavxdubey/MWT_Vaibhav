# define base docker image
FROM openjdk:11
LABEL maintainer="vaibhav"
ADD target/thinkingpad-0.0.1-SNAPSHOT.jar thinkingpad-docker.jar
ENTRYPOINT ["java", "-jar", "thinkingpad-docker.jar"]