FROM openjdk:11

VOLUME /tmp

LABEL microservices="apigateway"
LABEL description="zuul"

COPY target/apigateway-1.0.0-SNAPSHOT.jar /apigateway-1.0.0-SNAPSHOT.jar

EXPOSE 8765

ENTRYPOINT ["java", "-jar", "apigateway-1.0.0-SNAPSHOT.jar"]