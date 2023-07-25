FROM openjdk:17
ARG JAR_FILE=./auth/auth-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} auth.jar
ENTRYPOINT ["java","-jar","/auth.jar"]