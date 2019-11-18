# Notes

http://localhost:8888/person/dev
```json5
{
  "name": "person",
  "profiles": [
    "dev"
  ],
  "label": null,
  "version": "9c72b0dad3a13a3176111c3939ce7f98b7aa44d3",
  "state": null,
  "propertySources": [
    {
      "name": "https://github.com/JattMannu/configs/hello-world-3/person-dev.properties",
      "source": {
        "name": "DEV Jackson",
        "age": "54",
        "lang": "C#"
      }
    },
    {
      "name": "https://github.com/JattMannu/configs/hello-world-2/person-dev.properties",
      "source": {
        "name": "DEV Olly",
        "age": "36",
        "lang": "Java"
      }
    },
    {
      "name": "https://github.com/JattMannu/configs/hello-world-1/person-dev.properties",
      "source": {
        "name": "DEV Kelly",
        "age": "45",
        "lang": "Rust"
      }
    },
    {
      "name": "https://github.com/JattMannu/configs/application.properties",
      "source": {
        "name": "John Doe"
      }
    }
  ]
}
```

http://localhost:8888/person-qa.json
```json5
{"age":"32","name":"QA Marcus"}
```

http://localhost:8888/person-qa.yml
```yaml
age: '32'
name: QA Marcus
```