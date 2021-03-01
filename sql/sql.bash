docker build -t sqlrest .;
docker run -d --name sqlcontainer -it -p 8090:3306 -e MYSQL_ROOT_PASSWORD=IckyDitto9 sqlrest;