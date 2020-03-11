package com.serverless;

import java.util.Collections;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = LogManager.getLogger(Handler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("input: {}", input);
		LOG.info("context.getAwsRequestId(): {}", context.getAwsRequestId());
		LOG.info("context.getClientContext(): {}", context.getClientContext());
		LOG.info("context.getFunctionName(): {}", context.getFunctionName());
		LOG.info("context.getFunctionVersion(): {}", context.getFunctionVersion());
		LOG.info("context.getIdentity(): {}", context.getIdentity());
		LOG.info("context.getInvokedFunctionArn(): {}", context.getInvokedFunctionArn());
		LOG.info("context.getLogGroupName(): {}", context.getLogGroupName());
		LOG.info("context.getMemoryLimitInMB(): {}", context.getMemoryLimitInMB());
		Response responseBody = new Response("Go Serverless v1.x! Your function executed successfully!", input);
		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(responseBody)
				.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
				.build();
	}
}
