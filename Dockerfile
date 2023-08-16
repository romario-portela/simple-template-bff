FROM azul/zulu-openjdk-alpine:17-jre

ENV TZ America/Sao_Paulo
RUN apk update && apk upgrade && apk add ca-certificates && update-ca-certificates &&\
    apk add --update tzdata
VOLUME /tmp

RUN rm -rf /var/cache/apk/* && cp /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ADD glowroot /root/glowroot

ARG JAR_FILE

COPY src/main/resources/tzupdater.jar tzupdater.jar
COPY ${JAR_FILE} app.jar


COPY entrypoint.sh entrypoint.sh
ENTRYPOINT ./entrypoint.sh