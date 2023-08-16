#!/bin/sh

source /etc/profile

java -jar /tzupdater.jar -l  https://data.iana.org/time-zones/releases/tzdata2020a.tar.gz
java  -javaagent:/root/glowroot/glowroot.jar -jar -Djava.security.egd=file:/dev/./urandom /app.jar
