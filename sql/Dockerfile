FROM mysql

ENV MYSQL_DATABASE=oxfordscholar \
	MYSQL_ROOT_PASSWORD=OxfordScholar1! \
	MYSQL_USER=oxfordscholar \
	MYSQL_PASSWORD=OxfordScholar1!

EXPOSE 3306

COPY ./sql_scripts/ /docker-entrypoint-initdb.d/
RUN chown -R mysql:mysql /docker-entrypoint-initdb.d/
