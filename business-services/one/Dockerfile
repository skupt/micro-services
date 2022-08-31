FROM openjdk:11

VOLUME /tmp

LABEL microservices="one"
LABEL description="rest service"

COPY target/one-1.0.0-SNAPSHOT.jar /one-1.0.0-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "one-1.0.0-SNAPSHOT.jar"]