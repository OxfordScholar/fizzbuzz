docker build -t sqlrest .;
docker run -d --name sqlcontainer -it -p 3306:3306 -e MYSQL_ROOT_PASSWORD=OxfordScholar1! sqlrest;
