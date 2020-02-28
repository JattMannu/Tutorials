package com.my.dynamo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import software.amazon.awssdk.utils.IoUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LambdaRequestStreamHandler implements RequestStreamHandler {
    public void handleRequest(InputStream inputStream,
                              OutputStream outputStream, Context context) throws IOException {
        String input = IoUtils.toUtf8String(inputStream);
        outputStream.write(("Hello World - " + input).getBytes());
    }
}
