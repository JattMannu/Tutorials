
These are the configs used in to host the lamda via cloudformation. Should be similar to Terraform i guess.
``` 
tree .serverless/
   .serverless/
   ├── cloudformation-template-create-stack.json
   ├── cloudformation-template-update-stack.json
   └── serverless-state.json
```


### Testing the Endpoints
```
 curl -X POST  https://m1sprwom65.execute-api.ap-southeast-1.amazonaws.com/dev/accounts/1234/transactions -d '{"transaction_id":"foo", "amount": 20.50}'
```

https://lobster1234.github.io/2017/02/28/serverless-framework-java-maven-part-1/
https://lobster1234.github.io/2017/04/12/serverless-framework-aws-apigateway/
https://lobster1234.github.io/2017/04/15/serverless-framework-api-gateway-lambda-proxy/