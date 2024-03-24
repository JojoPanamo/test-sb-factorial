FROM openjdk:21
COPY ./target/test-sb-factorial-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","test-sb-factorial-0.0.1-SNAPSHOT.jar"]
EXPOSE 8090:8080
