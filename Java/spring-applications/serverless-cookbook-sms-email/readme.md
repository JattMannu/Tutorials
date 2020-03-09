aws sns subscribe \
--topic-arn arn:aws:sns:ap-southeast-1:472894326578:my-first-sns-topic-cf \
--protocol sms \
--notification-endpoint +6597121419
    
aws sns publish \
--topic-arn arn:aws:sns:ap-southeast-1:472894326578:my-first-sns-topic-cf \
--message "sending message to phone and email" 




https://github.com/svhawks/serverless-simple-sms


```sh
curl --location --request POST 'https://lmbn5yp070.execute-api.ap-southeast-1.amazonaws.com/dev/sms_aws' \
--header 'Content-Type: application/json' \
--data-raw '    {
    	"message": "enter text message here",
    	"phoneNumber": "+65xxxx",
    	"senderId": "manpreet",
    	"smsType": "Transactional"
    }'
    
```
    
curl -X POST https://******.execute-api.us-east-1.amazonaws.com/production/send --data '{ "message": "enter text message here", "phoneNumber": "+905391234567", }'


```
curl --location --request POST 'https://lmbn5yp070.execute-api.ap-southeast-1.amazonaws.com/dev/sms_aws' \
--header 'Content-Type: application/json' \
--data-raw '    {
    	"message": "I love u!",
    	"phoneNumber": "+91xxxx",
    	"senderId": "manpreet",
    	"smsType": "Transactional"
    }'
```