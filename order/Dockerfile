FROM openjdk:17
ARG JAR_FILE=./order/order-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} order.jar
ENTRYPOINT ["java","-jar","/order.jar"]