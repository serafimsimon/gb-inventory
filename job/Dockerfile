FROM openjdk:17
ARG JAR_FILE=./job/job-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} job.jar
ENTRYPOINT ["java","-jar","/job.jar"]