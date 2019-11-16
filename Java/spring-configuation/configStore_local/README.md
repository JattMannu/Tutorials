
### Endpoints to check configs
http://localhost:8888/app1/default
```json5
{
  "name": "app1",
  "profiles": [
    "default"
  ],
  "label": null,
  "version": null,
  "state": null,
  "propertySources": [
    {
      "name": "classpath:/config/app1.properties",
      "source": {
        "greeting": "hello"
      }
    }
  ]
}
```

http://localhost:8888/actuator/health
```json
{"status":"UP"}
```

http://localhost:8888/actuator
```json
{
  "_links": {
    "self": {
      "href": "http://localhost:8888/actuator",
      "templated": false
    },
    "health": {
      "href": "http://localhost:8888/actuator/health",
      "templated": false
    },
    "health-component": {
      "href": "http://localhost:8888/actuator/health/{component}",
      "templated": true
    },
    "health-component-instance": {
      "href": "http://localhost:8888/actuator/health/{component}/{instance}",
      "templated": true
    },
    "info": {
      "href": "http://localhost:8888/actuator/info",
      "templated": false
    }
  }
}
```