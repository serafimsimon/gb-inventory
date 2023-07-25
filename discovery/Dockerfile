FROM openjdk:17
ARG JAR_FILE=./discovery/discovery-0.0.1.jar
COPY ${JAR_FILE} discovery.jar
ENTRYPOINT ["java","-jar","/discovery.jar"]