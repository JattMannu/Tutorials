package com.serverless;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Map;

public class SendEmailHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = LogManager.getLogger(SendEmailHandler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received: {}", input);

		// Replace sender@example.com with your "From" address.
		// This address must be verified with Amazon SES.
		final String FROM = "manpreet@bhinder.net";

		// Replace recipient@example.com with a "To" address. If your account
		// is still in the sandbox, this address must be verified.
		final String TO = "manpreet@bhinder.net";

		// The configuration set to use for this email. If you do not want to use a
		// configuration set, comment the following variable and the
		// .withConfigurationSetName(CONFIGSET); argument below.
		//final String CONFIGSET = "ConfigSet";

		// The subject line for the email.
		final String SUBJECT = "Amazon SES test (AWS SDK for Java)";

		// The HTML body for the email.
		final String HTMLBODY = "<h1>Amazon SES test (AWS SDK for Java)</h1>"
				+ "<p>This email was sent with <a href='https://aws.amazon.com/ses/'>"
				+ "Amazon SES</a> using the <a href='https://aws.amazon.com/sdk-for-java/'>"
				+ "AWS SDK for Java</a>";

		// The email body for recipients with non-HTML email clients.
		final String TEXTBODY = "This email was sent through Amazon SES "
				+ "using the AWS SDK for Java.";

		try {
			AmazonSimpleEmailService client =
					AmazonSimpleEmailServiceClientBuilder.standard()
							// Replace US_WEST_2 with the AWS Region you're using for
							// Amazon SES.
							.withRegion(Regions.AP_SOUTH_1).build();
			SendEmailRequest request = new SendEmailRequest()
					.withDestination(
							new Destination().withToAddresses(TO))
					.withMessage(new Message()
							.withBody(new Body()
									.withHtml(new Content()
											.withCharset("UTF-8").withData(HTMLBODY))
									.withText(new Content()
											.withCharset("UTF-8").withData(TEXTBODY)))
							.withSubject(new Content()
									.withCharset("UTF-8").withData(SUBJECT)))
					.withSource(FROM);
					// Comment or remove the next line if you are not using a
					// configuration set
					//.withConfigurationSetName(CONFIGSET);
			client.sendEmail(request);
			LOG.info("Email sent!");
		} catch (Exception ex) {
			LOG.info("The email was not sent. Error message: "
					+ ex.getMessage());
		}


		Response responseBody = new Response("Go Serverless v1.x! Your function executed successfully!", input);
		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(responseBody)
				.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
				.build();
	}
}
