mvn clean install -DskipTests;

mvn package -DskipTests;

mvn k8s:build;

docker run -it -d -t access-controller-endpoints:0.0.1-SNAPSHOT -p 2000:9092 rest2