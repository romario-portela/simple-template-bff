#!/bin/sh

PROJETO=$1
PROFILE=$2
BRANCH=$3

#Remover images antigas do docker
CONTAINER_ID=$(docker ps -aqf "name=$PROJETO")
echo "CONTAINER: $CONTAINER_ID"

if [[ ! -z "$CONTAINER_ID" ]]; then
  docker stop $PROJETO
  docker rm $CONTAINER_ID
fi

IMAGE_ID=$(docker images --format="{{.Repository}} {{.ID}}" | grep -m1 "$PROJETO" | cut -d ' ' -f2)

echo "IMAGE: $IMAGE_ID"

if [[ ! -z "$IMAGE_ID" ]]; then
   docker rmi $IMAGE_ID --force
fi


mvn clean install -P $PROFILE

mvn dockerfile:build -P$PROFILE -DskipTests

#Push images no nexus
DOCKER_IMAGE=$(docker images --format {{.Repository}} | grep $PROJETO/$PROFILE)
docker push $DOCKER_IMAGE

#Captura IMAGE_ID do projeto
IMAGE_ID=$(docker images --format {{.ID}} `docker images --format {{.Repository}} | grep $PROJETO/$PROFILE`)

#Cria TAG_NAME latest
TAG_NAME=$(docker images --format {{.Repository}} | grep $PROJETO/$PROFILE)

#Cria tag latest
docker tag $IMAGE_ID $TAG_NAME:latest

#Push images no nexus
docker push $TAG_NAME:latest

#Cria tag da branch
docker tag $IMAGE_ID $TAG_NAME:$BRANCH

#Push images no nexus
docker push $TAG_NAME:$BRANCH