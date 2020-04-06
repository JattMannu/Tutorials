package com.serverless;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GetPresigneURLHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = LogManager.getLogger(GetPresigneURLHandler.class);

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {


        String bucketName = System.getenv("BUCKET_ID"); //"cs5224bucket-dev";
        String objectKey = "uploaded/ToDelete";
        String clientRegion = System.getenv("REGION");//"ap-southeast-1";

        Map<String, String> queryStringParameters = (Map<String, String>) input.get("queryStringParameters");
        LOG.info("input: {}", input);
        objectKey = String.format("%s/%s" , queryStringParameters.get("folder"),queryStringParameters.get("file"));
        LOG.info("objectKey: {}", objectKey);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(clientRegion)
                .build();

        // Set the presigned URL to expire after one hour.
        java.util.Date expiration = new java.util.Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 60;
        expiration.setTime(expTimeMillis);

        // Generate the presigned URL.
        System.out.println("Generating pre-signed URL.");
        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, objectKey)
                        .withMethod(HttpMethod.PUT)
                        .withExpiration(expiration);

        generatePresignedUrlRequest.addRequestParameter(Headers.S3_USER_METADATA_PREFIX + "email", "manpreet@bhinder.net");
        generatePresignedUrlRequest.addRequestParameter(Headers.S3_USER_METADATA_PREFIX + "telephone", "+6597121419");

        URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);

        LOG.info("Pre-Signed URL: {}", url.toString());
        System.out.println("Pre-Signed URL: " + url.toString());
        HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("url", url.toString());
        PreSignedURLResponse responseBody = new PreSignedURLResponse("SUCCESSFUL", returnMap);


        HashMap<String, String> headers = new HashMap<>();
        headers.put("Access-Control-Allow-Origin", "*");
        //  'Access-Control-Allow-Credentials': true,
        // https://serverless.com/blog/cors-api-gateway-survival-guide/
        return ApiGatewayResponse.builder()
                .setStatusCode(200)
                .setObjectBody(responseBody)
                .setHeaders(headers)
                .build();
    }


}

class PreSignedURLResponse {

    private final String message;
    private final Map<String, Object> input;

    public PreSignedURLResponse(String message, Map<String, Object> input) {
        this.message = message;
        this.input = input;
    }

    public String getMessage() {
        return this.message;
    }

    public Map<String, Object> getInput() {
        return this.input;
    }
}

