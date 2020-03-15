variable "aws_access_key" {}
variable "aws_secret_key" {}
variable "region" {
  default = "ap-southeast-1"
}

provider "aws" {
  access_key = var.aws_access_key
  secret_key = var.aws_secret_key
  region = var.region
}


resource "aws_iam_role" "iam_for_lambda_custom" {
  name = "iam_for_lambda_custom"

  assume_role_policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": "sts:AssumeRole",
      "Principal": {
        "Service": "lambda.amazonaws.com"
      },
      "Effect": "Allow",
      "Sid": ""
    }
  ]
}
EOF
}

resource "aws_lambda_function" "test_lambda" {
  filename = "./target/cloud-computing-pj-dev.jar"
  function_name = "handleRequest-0"
  role = aws_iam_role.iam_for_lambda_custom.arn
  handler = "com.serverless.Handler"

  # The filebase64sha256() function is available in Terraform 0.11.12 and later
  # For Terraform 0.11.11 and earlier, use the base64sha256() function and the file() function:
  # source_code_hash = "${base64sha256(file("lambda_function_payload.zip"))}"
  source_code_hash = filebase64sha256("./target/cloud-computing-pj-dev.jar")

  runtime = "java8"
  timeout = 6
  memory_size = 1024

  environment {
    variables = {
      EMAIL = "manpreet@bhinder.net"
      SMS = "+6597121419"
      BUCKET_ARN = aws_s3_bucket.bucket.arn
      SQS_ARN = aws_sqs_queue.queue.arn
    }
  }
  depends_on = [aws_iam_role_policy_attachment.lambda_logs, aws_cloudwatch_log_group.cs5224_send_sms]
}

resource "aws_lambda_function" "send_email" {
  filename = "./target/cloud-computing-pj-dev.jar"
  function_name = "cs5224-send-email"
  role = aws_iam_role.iam_for_lambda_custom.arn
  handler = "com.serverless.SendEmailHandler"

  # The filebase64sha256() function is available in Terraform 0.11.12 and later
  # For Terraform 0.11.11 and earlier, use the base64sha256() function and the file() function:
  # source_code_hash = "${base64sha256(file("lambda_function_payload.zip"))}"
  source_code_hash = filebase64sha256("./target/cloud-computing-pj-dev.jar")

  runtime = "java8"
  timeout = 6
  memory_size = 1024

  environment {
    variables = {
      EMAIL = "manpreet@bhinder.net"
      BUCKET_ARN = aws_s3_bucket.bucket.arn
    }
  }
  depends_on = [aws_iam_role_policy_attachment.lambda_logs, aws_cloudwatch_log_group.cs5224_send_email]
}

# Permission to send email
resource "aws_iam_role_policy" "sendemail_policy" {
  name = "sendemail_lambda_policy"
  role = "${aws_iam_role.iam_for_lambda_custom.id}"

  policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": [
        "ses:SendEmail",
        "ses:SendRawEmail"
      ],
      "Effect": "Allow",
      "Resource": "*"
    }
  ]
}
EOF
}

resource "aws_lambda_function" "send_sms" {
  filename = "./target/cloud-computing-pj-dev.jar"
  function_name = "cs5224-send-sms"
  role = aws_iam_role.iam_for_lambda_custom.arn
  handler = "com.serverless.SendSMSHandler"

  # The filebase64sha256() function is available in Terraform 0.11.12 and later
  # For Terraform 0.11.11 and earlier, use the base64sha256() function and the file() function:
  # source_code_hash = "${base64sha256(file("lambda_function_payload.zip"))}"
  source_code_hash = filebase64sha256("./target/cloud-computing-pj-dev.jar")

  runtime = "java8"
  timeout = 6
  memory_size = 1024


  environment {
    variables = {
      SMS = "+6597121419"
      BUCKET_ARN = aws_s3_bucket.bucket.arn
    }
  }
}


resource "aws_s3_bucket" "bucket" {
  acl = "public-read"
  force_destroy = true

  cors_rule {
    allowed_headers = [
      "*"]
    allowed_origins = [
      "*"]
    allowed_methods = [
      "GET",
      "PUT",
      "POST",
      "DELETE",
      "HEAD"]
  }
}


resource "aws_s3_bucket_object" "toProcess" {
  bucket = aws_s3_bucket.bucket.id
  acl    = "public-read"
  key    = "toProcess/"
  source = "/dev/null"
}

resource "aws_s3_bucket_object" "processed" {
  bucket = aws_s3_bucket.bucket.id
  acl    = "public-read"
  key    = "processed/"
  source = "/dev/null"
}


resource "aws_sqs_queue" "queue" {
  name = "s3-event-notification-queue"

  policy = <<POLICY
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": "*",
      "Action": "sqs:SendMessage",
      "Resource": "arn:aws:sqs:*:*:s3-event-notification-queue",
      "Condition": {
        "ArnEquals": { "aws:SourceArn": "${aws_s3_bucket.bucket.arn}" }
      }
    }
  ]
}
POLICY
}

resource "aws_sns_topic" "topic_toProcess" {
  name = "s3-event-notification-toProcess"

  policy = <<POLICY
{
    "Version":"2012-10-17",
    "Statement":[{
        "Effect": "Allow",
        "Principal": {"AWS":"*"},
        "Action": "SNS:Publish",
        "Resource": "arn:aws:sns:*:*:s3-event-notification-toProcess",
        "Condition":{
            "ArnLike":{"aws:SourceArn":"${aws_s3_bucket.bucket.arn}"}
        }
    }]
}
POLICY
}

resource "aws_sns_topic" "topic_processed" {
  name = "s3-event-notification-processed"

  policy = <<POLICY
{
    "Version":"2012-10-17",
    "Statement":[{
        "Effect": "Allow",
        "Principal": {"AWS":"*"},
        "Action": "SNS:Publish",
        "Resource": "arn:aws:sns:*:*:s3-event-notification-processed",
        "Condition":{
            "ArnLike":{"aws:SourceArn":"${aws_s3_bucket.bucket.arn}"}
        }
    }]
}
POLICY
}

resource "aws_s3_bucket_notification" "bucket_notification" {
  bucket = aws_s3_bucket.bucket.id

  topic {
    topic_arn     = aws_sns_topic.topic_toProcess.arn
    events        = ["s3:ObjectCreated:*"]
    filter_prefix = "toProcess/"
  }

  topic {
    topic_arn     = aws_sns_topic.topic_processed.arn
    events        = ["s3:ObjectCreated:*"]
    filter_prefix = "processed/"
  }
}

resource "aws_sns_topic_subscription" "mapping-toProcess" {
  topic_arn = aws_sns_topic.topic_processed.arn
  protocol  = "lambda"
  endpoint  = aws_lambda_function.send_email.arn
}

resource "aws_sns_topic_subscription" "mapping-processed" {
  topic_arn = aws_sns_topic.topic_processed.arn
  protocol  = "lambda"
  endpoint  = aws_lambda_function.send_sms.arn
}


### Added Logging for Lambdas
resource "aws_cloudwatch_log_group" "cs5224_send_email" {
  name              = "/aws/lambda/cs5224-send-email"
  retention_in_days = 14
}

resource "aws_cloudwatch_log_group" "cs5224_send_sms" {
  name              = "/aws/lambda/cs5224-send-sms"
  retention_in_days = 14
}


# See also the following AWS managed policy: AWSLambdaBasicExecutionRole
resource "aws_iam_policy" "lambda_logging" {
  name        = "lambda_logging"
  path        = "/"
  description = "IAM policy for logging from a lambda"

  policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": [
        "logs:CreateLogGroup",
        "logs:CreateLogStream",
        "logs:PutLogEvents"
      ],
      "Resource": "arn:aws:logs:*:*:*",
      "Effect": "Allow"
    }
  ]
}
EOF
}


# See also the following AWS managed policy: AWSLambdaBasicExecutionRole
resource "aws_iam_policy" "lambda_sms" {
  name        = "lambda_sms"
  path        = "/"
  description = "IAM policy for SMS from a lambda"

  policy = <<EOF
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "sns:Publish",
            "Resource": "*"
        }
    ]
}
EOF
}



resource "aws_lambda_permission" "with_sns_send_email" {
  statement_id = "AllowExecutionFromSNS"
  action = "lambda:InvokeFunction"
  function_name = "${aws_lambda_function.send_email.arn}"
  principal = "sns.amazonaws.com"
  source_arn = "${aws_sns_topic.topic_processed.arn}"
}

resource "aws_lambda_permission" "with_sns_send_sms" {
  statement_id = "AllowExecutionFromSNS"
  action = "lambda:InvokeFunction"
  function_name = "${aws_lambda_function.send_sms.arn}"
  principal = "sns.amazonaws.com"
  source_arn = "${aws_sns_topic.topic_processed.arn}"
}

resource "aws_iam_role_policy_attachment" "lambda_logs" {
  role       = aws_iam_role.iam_for_lambda_custom.name
  policy_arn = aws_iam_policy.lambda_logging.arn
}

resource "aws_iam_role_policy_attachment" "lambda_sms" {
  role       = aws_iam_role.iam_for_lambda_custom.name
  policy_arn = aws_iam_policy.lambda_sms.arn
}