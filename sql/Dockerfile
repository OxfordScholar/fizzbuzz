FROM mysql

ENV MYSQL_DATABASE data

EXPOSE 3306

COPY ./sql_scripts/ /docker-entrypoint-initdb.d/
