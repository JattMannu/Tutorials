

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