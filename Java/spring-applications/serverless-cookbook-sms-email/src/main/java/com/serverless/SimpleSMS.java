package com.serverless;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

import java.util.HashMap;
import java.util.Map;

public class SimpleSMS {

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