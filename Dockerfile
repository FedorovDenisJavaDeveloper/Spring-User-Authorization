FROM openjdk:17-jdk-alpine

EXPOSE 8080

COPY target/Exception-0.0.1-SNAPSHOT.jar exception.jar

CMD ["java","-jar","exception.jar"]