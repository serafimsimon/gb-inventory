FROM openjdk:17
ARG JAR_FILE=./department/department-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} department.jar
ENTRYPOINT ["java","-jar","/department.jar"]