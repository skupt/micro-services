FROM openjdk:11

VOLUME /tmp

LABEL microservices="two"
LABEL description="feign client for rest service one"

COPY target/two-1.0.0-SNAPSHOT.jar /two-1.0.0-SNAPSHOT.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "two-1.0.0-SNAPSHOT.jar"]