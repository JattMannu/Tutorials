FROM openjdk:11.0-jdk-stretch

EXPOSE 80
EXPOSE 12889


ENTRYPOINT ["/usr/local/openjdk-11/bin/java", "-XX:+UseContainerSupport", "-Dspring.profiles.active=prod", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/target/ms.jar"]
#ENTRYPOINT ["/bin/bash"]
ARG JAR_FILE

COPY target target
COPY ${JAR_FILE} target/ms.jar

#https://stackoverflow.com/questions/48957195/how-to-fix-docker-got-permission-denied-issue

# docker run -it openjdk:11.0-jdk-stretch bin/bash
# docker run -P jattmannu/mongodb-service:latest
# docker run -p 8084:80 jattmannu/mongodb-service:latest
# docker run -it --rm --entrypoint=/bin/bash jattmannu/mongodb-service:latest
# java -jar mongodb-service-0.0.1-SNAPSHOT.jar


# login then push
# mvn dockerfile:push




# java -Dspring.profiles.active=prod -jar target/mongodb-service-0.0.1-SNAPSHOT.jar
# java -Dspring.profiles.active=prod -Dspring.data.mongodb.uri=mongodb://simmi1:simmi1@ds012889.mlab.com:12889/rubbish?retryWrites=false -jar target/mongodb-service-0.0.1-SNAPSHOT.jar
# 2019-12-03 08:55:24.164  INFO 90 --- [p-nio-80-exec-1] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:2, serverValue:681605}] to ds012889.mlab.com:12889
