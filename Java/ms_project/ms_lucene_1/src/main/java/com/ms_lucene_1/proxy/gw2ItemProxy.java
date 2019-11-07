package com.ms_lucene_1.proxy;

import org.bson.BsonDocument;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class gw2ItemProxy {

    public BsonDocument getItem(String itemId){

        String https_url = String.format("https://api.guildwars2.com/v2/items/%s",itemId);
        URL url;
        try {

            url = new URL(https_url);
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            BufferedReader br = new BufferedReader(isr);
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();

            while ((inputLine = br.readLine()) != null) {
                stringBuilder.append(inputLine);
            }

            br.close();

            return BsonDocument.parse(stringBuilder.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new BsonDocument();
    }
}
