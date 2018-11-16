docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)
./gradlew dockerBuildImage
docker-compose up
