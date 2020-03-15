package com.serverless;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SendSMSHandler implements RequestHandler<Map<String, Object>, String> {

    private static final Logger LOG = LogManager.getLogger(SendSMSHandler.class);

    @Override
    public String handleRequest(Map<String, Object> input, Context context) {
        LOG.info("received: " + input);

        context.getLogger().log("SendSMSHandler triggered");

        String senderId = "Manpreet";
        String smsType = "Transactional";
        context.getLogger().log("SendSMSHandler simpleSMS creating");
        SimpleSMS simpleSMS = new SimpleSMS(senderId, smsType);
        context.getLogger().log("SendSMSHandler simpleSMS created");

        String message = "Image Processed";
        String phoneNumber = "+6597121419";

        String res;
        try {
            res = simpleSMS.sendSMSMessage(message, phoneNumber);
            LOG.info("Sent an SMS '" + message + "' to " + phoneNumber + " : " + res);
        } catch (Exception e) {
            LOG.error("An error occured: " + e.getMessage());
            res = new ErrorResponse("An error occured: " + e).toJson();
        }

        return res;
    }
}

class SimpleSMS {

    private Map<String, MessageAttributeValue> smsAttributes;

    public SimpleSMS(String senderID, String smsType) {

        smsAttributes =
                new HashMap<String, MessageAttributeValue>();

        smsAttributes.put("AWS.SNS.SMS.SenderID", new MessageAttributeValue()
                .withStringValue(senderID) //The sender ID shown on the device.
                .withDataType("String"));

        smsAttributes.put("AWS.SNS.SMS.SMSType", new MessageAttributeValue()
                .withStringValue(smsType) //Sets the type to promotional.
                .withDataType("String"));

    }

    public String sendSMSMessage(String message,
                                 String phoneNumber) {

        AmazonSNSClient snsClient = new AmazonSNSClient(new ClientConfiguration());


        PublishResult result = snsClient.publish(new PublishRequest()
                .withMessage(message)
                .withPhoneNumber(phoneNumber)
                .withMessageAttributes(smsAttributes));

        return result.toString(); // Returns the message ID.
    }

}
