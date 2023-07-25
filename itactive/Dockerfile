FROM openjdk:17
ARG JAR_FILE=./itactive/itactive-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} itactive.jar
ENTRYPOINT ["java", "-jar", "/itactive.jar"]