package com.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Map;

public class PushToSQS implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = LogManager.getLogger(PushToSQS.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("input: {}", input);


		SendMessageRequest send_msg_request = new SendMessageRequest()
				.withQueueUrl(queueUrl)
				.withMessageBody("hello world")
				.withDelaySeconds(5);
		sqs.sendMessage(send_msg_request);
		Response responseBody = new Response("Go Serverless v1.x! Your function executed successfully!", input);
		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(responseBody)
				.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
				.build();
	}
}
