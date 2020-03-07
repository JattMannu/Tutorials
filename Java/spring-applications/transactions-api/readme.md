
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