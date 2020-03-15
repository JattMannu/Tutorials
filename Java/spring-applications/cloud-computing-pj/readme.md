


```
terraform init
terraform plan -out="terra.tfplan" 
terraform apply "terra.tfplan"

terraform plan -out="terra.tfplan" && terraform apply "terra.tfplan"
terraform destroy



```

```roomsql


resource "aws_s3_bucket_notification" "bucket_notification" {
  bucket = aws_s3_bucket.bucket.id

  #queue {
  #  id = "toProcess-event"
  #  queue_arn = aws_sqs_queue.queue.arn
  #  events = [
  #    "s3:ObjectCreated:*"]
  #  filter_prefix = "toProcess/"
  #}

  #queue {
   # id = "processed-event"
   # queue_arn = aws_sqs_queue.queue.arn
   # events = [
   #   "s3:ObjectCreated:*"]
   # filter_prefix = "processed/"
  #}

 # lambda_function {
 #   id = "toProcess-lambda"
 #   lambda_function_arn = "${aws_lambda_function.test_lambda.arn}"
 #   events              = ["s3:ObjectCreated:*"]
 #   filter_prefix       = "toProcess/"
  #}

  topic {
    topic_arn     = "${aws_sns_topic.topic_toProcess.arn}"
    events        = ["s3:ObjectCreated:*"]
    filter_prefix = "toProcess/"
  }

  topic {
    topic_arn     = "${aws_sns_topic.topic_processed.arn}"
    events        = ["s3:ObjectCreated:*"]
    filter_prefix = "processed/"
  }

  #depends_on = [aws_lambda_permission.allow_bucket]
}

# resource "aws_lambda_event_source_mapping" "send_email_mapping" {
#  event_source_arn = "${aws_sqs_queue.queue.arn}"
#  function_name    = "${aws_lambda_function.test_lambda.arn}"
#}

resource "aws_lambda_permission" "allow_bucket" {
  statement_id  = "AllowExecutionFromS3Bucket"
  action        = "lambda:InvokeFunction"
  function_name = "${aws_lambda_function.test_lambda.arn}"
  principal     = "s3.amazonaws.com"
  source_arn    = "${aws_s3_bucket.bucket.arn}"
}

resource "aws_sns_topic_subscription" "toProcess_lamada_target" {
  topic_arn = aws_sns_topic.topic_toProcess.arn
  protocol  = "lambda"
  endpoint  = aws_lambda_function.test_lambda.arn
}

resource "aws_sns_topic_subscription" "processed_lamada_target" {
  topic_arn = aws_sns_topic.topic_processed.arn
  protocol  = "lambda"
  endpoint  = aws_lambda_function.test_lambda.arn
}

```