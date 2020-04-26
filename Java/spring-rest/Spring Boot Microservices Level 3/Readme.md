
https://www.baeldung.com/spring-cloud-configuration

### Using external property sources with Spring Boot - Microservice configuration with Spring Boot [04]

cd to target folder
```
touch application.properties
echo "my.greeting=external world" > application.properties
cat application.properties OR less application.properties
java -jar spring-boot-config-0.0.1-SNAPSHOT.jar
curl localhost:8080/greeting
```
Should print external world

Another approach is : 

```java -jar spring-boot-config-0.0.1-SNAPSHOT.jar --my.greeting="Hello from command line\!"```


Should print: Hello from command line!%  


### Spring profiles explained - Microservice configuration with Spring Boot [08]
```java -jar spring-boot-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=test,test-b```


### Set up spring cloud config server from scratch - Microservice configuration with Spring Boot [11]

```
http://localhost:8888/<filename_without_ext>/<profile>
```
working:
```
http://localhost:8888/application/default
//No idea what is this.
http://localhost:8888/spring-cloud-config-server/application
```

```
2020-04-26 16:52:37.434  INFO 36739 --- [           main] c.c.c.ConfigServicePropertySourceLocator : Fetching config from server at : http://localhost:8888
```

### Dynamic config with spring Boot - Microservice configuration with Spring Boot [13]

You can use actuator to tell the microservice to refresh. 

!!! We only refresh those beans that are marked ```@RefreshScope```

to restart 
curl --location --request POST 'localhost:8080/actuator/refresh' | jq

response : 
```json5
[
  "config.client.version",
  "my.greeting"
]
```