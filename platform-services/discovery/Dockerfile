FROM openjdk:8

VOLUME /tmp

LABEL microservices="discovery"
LABEL description="eureka"

COPY target/discovery-1.0.0-SNAPSHOT.jar discovery-1.0.0-SNAPSHOT.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "discovery-1.0.0-SNAPSHOT.jar"]