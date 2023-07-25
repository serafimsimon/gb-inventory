FROM openjdk:17
ARG JAR_FILE=./apigateway/apigateway-0.0.1.jar
COPY ${JAR_FILE} apigateway.jar
ENTRYPOINT ["java","-jar","/apigateway.jar"]
