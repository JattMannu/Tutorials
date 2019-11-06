package com.lucene.demo;

import com.lucene.demo.indexer.InjectableJsonIndexWriter;
import org.apache.lucene.document.IntPoint;
import org.bson.BsonValue;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String... args)throws IOException, ParseException {

        String INDEX_PATH = "index_dir";
        String JSON_DUMPS= "/data_dump/";

        try {
            //JsonIndexWriter lw = new JsonIndexWriter(INDEX_PATH, JSON_DUMPS);
            InjectableJsonIndexWriter lw = new InjectableJsonIndexWriter(INDEX_PATH, JSON_DUMPS);
            lw.addCustomlogic("root.details.infix_upgrade.attributes", (bsonValue, key, document) -> {
                for (BsonValue obj : bsonValue.asArray()) {
                    document.add(
                            new IntPoint(
                                    "root.details.infix_upgrade.attributes:attribute."+obj.asDocument().get("attribute").asString().getValue().toLowerCase(),
                                    obj.asDocument().get("modifier").asInt32().getValue()));

                }
                return false;
            });
            lw.createIndex();

//            //Check the index has been created successfully
//            Directory indexDirectory = FSDirectory.open(new File(INDEX_PATH));
//            IndexReader indexReader = DirectoryReader.open(indexDirectory);
//
//            int numDocs = indexReader.numDocs();
//
//            for ( int i = 0; i < numDocs; i++)
//            {
//                Document document = indexReader.document(i);
//                System.out.println( "d=" +document);
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
