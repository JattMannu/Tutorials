serverless create --template aws-java-maven

Needed to rename the module , defaults to "hello"


serverless info

The user has no permission

### Faq commands
```
mvn clean install
serverless deploy
serverless info

serverless invoke --function hello

serverless invoke --function test

serverless invoke --function hello --data '{"key":"value"}'

serverless metrics

serverless metrics --function hello

```


##### aws-java-maven/serverless.yml
```
provider:
  name: aws
  runtime: java8
  region: ap-southeast-1

```