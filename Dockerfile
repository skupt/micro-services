FROM java:8-jre-alpine

VOLUME /tmp

LABEL ${LABEL_GROUP}="${LABEL_ID}"
LABEL description="${LABEL_DESCRIPTION}"

COPY ${JAR_NAME_TO_RUN} /${JAR_NAME_TO_RUN}

EXPOSE ${PORT_TO_EXPOSE}

ENTRYPOINT ["java", "-jar", "/${JAR_NAME_TO_RUN}"]