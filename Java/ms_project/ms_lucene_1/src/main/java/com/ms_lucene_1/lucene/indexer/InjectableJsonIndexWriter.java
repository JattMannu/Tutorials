package com.ms_lucene_1.lucene.indexer;


import com.ms_lucene_1.lucene.abstraction.Function;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.bson.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

public class InjectableJsonIndexWriter {

    private String indexPath = "";
    private String jsonFolderPath = "";
    private IndexWriter indexWriter = null;
    private String ROOT = "root";

    private HashMap<String, Function> injects;

    public InjectableJsonIndexWriter(String indexPath, String jsonFolderPath) {
        this.indexPath = indexPath;
        this.jsonFolderPath = jsonFolderPath;
        this.injects = new HashMap<>();
    }

    public void addCustomlogic(String key, Function function) {
        this.injects.put(key, function);
    }

    public void createIndex() {
        getClass().getResource(this.jsonFolderPath);
        openIndex();
        try (Stream<Path> paths = Files.walk(Paths.get(getClass().getResource(this.jsonFolderPath).getPath()))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> {
                        System.out.println(path.toString());
                        try {
                            BsonDocument jsonObjects = parseBSONFile(path.toString());
                            Document doc = new Document();
                            addDocument(jsonObjects, this.ROOT, doc);
                            System.out.println(doc.toString());
                            try {
                                indexWriter.addDocument(doc);
                            } catch (IOException ex) {
                                System.err.println("Error adding documents to the index. " + ex.getMessage());
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }

                    });
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONObject parseJSONFile(String path) throws FileNotFoundException {

        //Get the JSON file, in this case is in ~/resources/test.json
        InputStream jsonFile = new FileInputStream(path);
        Reader readerJson = new InputStreamReader(jsonFile);

        //Parse the json file using simple-json library
        Object fileObjects = JSONValue.parse(readerJson);

        JSONObject arrayObject = (JSONObject) fileObjects;

        return arrayObject;

    }

    public BsonDocument parseBSONFile(String path) throws FileNotFoundException {
        //Get the JSON file, in this case is in ~/resources/test.json
        InputStream jsonFile = new FileInputStream(path);
        Reader readerJson = new InputStreamReader(jsonFile);

        //Parse the json file using simple-json library
        Object fileObjects = JSONValue.parse(readerJson);

        JSONObject arrayObject = (JSONObject) fileObjects;
        BsonDocument document = BsonDocument.parse(((JSONObject) fileObjects).toJSONString());

        return document;
    }

    public void addDocument(BsonDocument document, String _key, Document doc) {

        document.keySet().forEach(key -> {
            BsonValue bsonValue = document.get(key);
            if (bsonValue.isArray()) addDocument(bsonValue.asArray(), String.format("%s.%s", _key, key), doc);
            else if (bsonValue.isDocument())
                addDocument(bsonValue.asDocument(), String.format("%s.%s", _key, key), doc);
            else addDocument(bsonValue, String.format("%s.%s", _key, key), doc);
        });

    }

    public void addDocument(BsonArray document, String key, Document doc) {
        if (injects.containsKey(key) && injects.get(key).apply(document, key, doc))
            return;

        for (BsonValue bsonValue : document) {
            if (bsonValue.isArray()) addDocument(bsonValue.asArray(), key, doc);
            else if (bsonValue.isDocument()) addDocument(bsonValue.asDocument(), key, doc);
            else addDocument(bsonValue, key, doc);
        }

    }

    public void addDocument(BsonValue bsonValue, String key, Document doc) {
        if (bsonValue.isString()) addDocument(bsonValue.asString(), key, doc);
        else if (bsonValue.isInt64()) addDocument(bsonValue.asInt64(), key, doc);
        else if (bsonValue.isInt32()) addDocument(bsonValue.asInt32(), key, doc);
        else if (bsonValue.isDouble()) addDocument(bsonValue.asDouble(), key, doc);
        else if (bsonValue.isBoolean()) addDocument(bsonValue.asBoolean(), key, doc);
        else {
            System.out.println("STOP");
        }
    }

    public void addDocument(BsonString document, String key, Document doc) {
        doc.add(new TextField(key, document.getValue(), Field.Store.YES));
        doc.add(new TextField(this.ROOT, document.getValue(), Field.Store.YES));
    }

    public void addDocument(BsonInt64 document, String key, Document doc) {
        //doc.add(new LongPoint(key, document.getValue(), Field.Store.YES));
        doc.add(new LongPoint(key, document.getValue()));
        addDocument(new BsonString(document.getValue() + ""), key, doc);
    }

    public void addDocument(BsonInt32 document, String key, Document doc) {
        doc.add(new IntPoint(key, document.getValue()));
        addDocument(new BsonString(document.getValue() + ""), key, doc);
    }

    public void addDocument(BsonDouble document, String key, Document doc) {
        doc.add(new DoublePoint(key, document.getValue()));
        addDocument(new BsonString(document.getValue() + ""), key, doc);
    }

    public void addDocument(BsonBoolean document, String key, Document doc) {
        doc.add(new StringField(key, Boolean.toString(document.getValue()), Field.Store.YES));
        //addDocument(new BsonString( Boolean.toString(document.getValue())), key, doc);
    }

    public boolean openIndex() {
        try {

            Directory dir = FSDirectory.open(new File(indexPath).toPath());
            Analyzer analyzer = new StandardAnalyzer();
            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);

            //Always overwrite the directory
            iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            indexWriter = new IndexWriter(dir, iwc);

            return true;
        } catch (Exception e) {
            System.err.println("Error opening the index. " + e.getMessage());

        }
        return false;

    }

    public void finish() {
        try {
            indexWriter.commit();
            indexWriter.close();
        } catch (IOException ex) {
            System.err.println("We had a problem closing the index: " + ex.getMessage());
        }
    }


}
