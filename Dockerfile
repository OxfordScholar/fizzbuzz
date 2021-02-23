FROM tomcat:10

COPY restV2/restV2/target/restV2.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD [“catalina.sh”, “run”]
