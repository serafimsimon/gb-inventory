FROM openjdk:17
ARG JAR_FILE=./user/user-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} user.jar
ENTRYPOINT ["java","-jar","/user.jar"]