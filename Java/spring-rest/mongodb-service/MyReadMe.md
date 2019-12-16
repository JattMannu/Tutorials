

##### Setting profile
```
spring_profiles_active=dev
```


https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html


/usr/share/maven/conf/settings.xml





### Swagger
https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X

```
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>${springfox-swagger.version}</version>
        </dependency>

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>${springfox-swagger.version}</version>
        </dependency>

```

```com.example.demo.configuration.SwaggerConfig``` added.
```
http://localhost:8084/v2/api-docs
```

```
2019-12-16 13:15:24.507  INFO 22325 --- [           main] pertySourcedRequestMappingHandlerMapping : Mapped URL path [/v2/api-docs] onto method [springfox.documentation.swagger2.web.Swagger2Controller#getDocumentation(String, HttpServletRequest)]
```

UI = ```http://localhost:8084/swagger-ui.html```