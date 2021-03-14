# SQL Database for OxfordScholar

The following commands are used to build the image from Dockerfile (the following will build the image named customsqltest) and to run and execute the mysql container:
```
docker build . -t customsqltest
docker run -d --name mysql -p 3306:3306 customsqltest
```

The following can be used to query the mysql container;
```
docker exec -it mysql bash
mysql -u oxfordscholar -p oxfordscholar

-- from there you can run your SQL Statements
```

The following are some standard docker commands (rm removes container, rmi removes image):
```
docker rm mysql
docker rmi customsqltest
```