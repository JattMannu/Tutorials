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
import org.bson.BsonString;
import org.bson.BsonValue;
import org.json.simple.JSONArray;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.LinkedList;

@org.springframework.web.bind.annotation.RestController
public class LuceneRestController {


    @RequestMapping(value = "/qqq", method = RequestMethod.GET,  produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public String qqq(@RequestParam(required = false)String q) {
        String INDEX_PATH = "index_dir";
        MyIndexSearcher myIndexSearcher = null;

        byte[] decodedBytes = Base64.getDecoder().decode(q);
        String decodedString = new String(decodedBytes);

        try {
            myIndexSearcher = new MyIndexSearcher(new File(INDEX_PATH));


            TopDocs topDocs = myIndexSearcher.search(new QueryParser("root", new StandardAnalyzer()) {
            }.parse(decodedString));

            //"root.details.max_power:[500 TO 909] AND root.details.type:Scepter AND Vis~"


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


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/w", method = RequestMethod.GET,  produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public String[] w(@RequestParam(required = false)String q) {
        String INDEX_PATH = "index_dir";
        MyIndexSearcher myIndexSearcher = null;

        byte[] decodedBytes = Base64.getDecoder().decode(q);
        String decodedString = new String(decodedBytes);

        try {
            myIndexSearcher = new MyIndexSearcher(new File(INDEX_PATH));


            TopDocs topDocs = myIndexSearcher.search(new QueryParser("root", new StandardAnalyzer()) {
            }.parse(decodedString));

            ScoreDoc[] hits = topDocs.scoreDocs;

            System.out.println("Found " + hits.length + " hits.");
            String[] result = new String[hits.length];

            for (int i = 0; i < hits.length; ++i) {
                int docId = hits[i].doc;
                Document d = myIndexSearcher.doc(docId);
                System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type") + "\t" + d.get("root.details.max_power"));
                result[i] = d.get("root.name");
            }
            return result;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return new String[0];
    }
}

