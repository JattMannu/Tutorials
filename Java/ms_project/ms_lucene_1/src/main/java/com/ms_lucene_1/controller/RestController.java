package com.ms_lucene_1.controller;

import com.ms_lucene_1.lucene.indexer.InjectableJsonIndexWriter;
import com.ms_lucene_1.lucene.searcher.MyIndexSearcher;
import com.ms_lucene_1.proxy.gw2ItemProxy;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonValue;
import org.json.simple.JSONArray;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping(value = "/s", method = RequestMethod.GET)
    public String search() {
        return "Hello!";
    }


    @RequestMapping(value = "/i", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String item() {
        return new gw2ItemProxy().getItem("28445").toJson();
    }

    @RequestMapping(value = "/i/{itemId}", method = RequestMethod.GET)
    public String item(@PathVariable String itemId) {
        return new gw2ItemProxy().getItem(itemId).toJson();
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public boolean index() {


        String INDEX_PATH = "index_dir";
        String JSON_DUMPS= "/tmp/";

        try {
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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    @RequestMapping(value = "/q", method = RequestMethod.GET)
    public String[] q() {
        String INDEX_PATH = "index_dir";
        MyIndexSearcher myIndexSearcher = null;
        try {
            myIndexSearcher = new MyIndexSearcher(new File(INDEX_PATH));


        TopDocs topDocs = myIndexSearcher.search(new QueryParser("root", new StandardAnalyzer()) {
        }.parse("root.details.max_power:[500 TO 909] AND root.details.type:Scepter AND Vision"));

        ScoreDoc[] hits = topDocs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        String[] result = new String[hits.length];
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = myIndexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type") + "\t" + d.get("root.details.max_power"));
            result[i] = d.get("root.id");
        }
            return result;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return new String[0];
    }

    @RequestMapping(value = "/qq", method = RequestMethod.GET,  produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public String qq() {
        String INDEX_PATH = "index_dir";
        MyIndexSearcher myIndexSearcher = null;
        try {
            myIndexSearcher = new MyIndexSearcher(new File(INDEX_PATH));


            TopDocs topDocs = myIndexSearcher.search(new QueryParser("root", new StandardAnalyzer()) {
            }.parse("root.details.max_power:[500 TO 909] AND root.details.type:Scepter AND Vision"));

            ScoreDoc[] hits = topDocs.scoreDocs;

            System.out.println("Found " + hits.length + " hits.");
            BsonArray result = new BsonArray();

            for (int i = 0; i < hits.length; ++i) {
                int docId = hits[i].doc;
                Document d = myIndexSearcher.doc(docId);
                System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type") + "\t" + d.get("root.details.max_power"));
                result.add(new gw2ItemProxy().getItem(d.get("root.id")));
            }
            return result.getValues().toString();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return JSONArray.toJSONString(new LinkedList<>());
    }

}

