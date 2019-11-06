package com.lucene.demo;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.util.List;
import java.util.Set;


/**
 * Created by suay on 5/13/14.
 * https://raw.githubusercontent.com/ignacioSuay/luceneSample/master/src/main/java/com/ignaciosuay/writer/LuceneIndexWriter.java
 */
public class LuceneIndexWriter {

    String indexPath = "";

    String jsonFilePath = "";

    IndexWriter indexWriter = null;

    public LuceneIndexWriter(String indexPath, String jsonFilePath) {
        this.indexPath = indexPath;
        this.jsonFilePath = jsonFilePath;
    }

    public void createIndex(){
        JSONArray jsonObjects = parseJSONFile();
        openIndex();
        addDocuments(jsonObjects);
        finish();
    }

    /**
     * Parse a Json file. The file path should be included in the constructor
     */
    public JSONArray parseJSONFile(){

        //Get the JSON file, in this case is in ~/resources/test.json
        InputStream jsonFile =  getClass().getResourceAsStream(jsonFilePath);
        Reader readerJson = new InputStreamReader(jsonFile);

        //Parse the json file using simple-json library
        Object fileObjects= JSONValue.parse(readerJson);
        JSONArray arrayObjects=(JSONArray)fileObjects;

        return arrayObjects;

    }

    public boolean openIndex(){
        try {
            Directory dir = FSDirectory.open(new File(indexPath).toPath());
            Analyzer analyzer = new StandardAnalyzer();
            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);

            //Always overwrite the directory
            iwc.setOpenMode(OpenMode.CREATE);
            indexWriter = new IndexWriter(dir, iwc);

            return true;
        } catch (Exception e) {
            System.err.println("Error opening the index. " + e.getMessage());

        }
        return false;

    }

    /**
     * Add documents to the index
     */
    public void addDocuments(JSONArray jsonObjects){
        for(JSONObject object : (List<JSONObject>) jsonObjects){
            Document doc = new Document();
            for(String field : (Set<String>) object.keySet()){
                Class type = object.get(field).getClass();
                if(type.equals(String.class)){
                    doc.add(new StringField(field, (String)object.get(field), Field.Store.NO));
                }else if(type.equals(Long.class)){
                    doc.add(new LongPoint(field, (Long) object.get(field)));
                }else if(type.equals(Double.class)){
                    doc.add(new DoublePoint(field, (Double) object.get(field)));
                }else if(type.equals(Boolean.class)){
                    doc.add(new StringField(field, object.get(field).toString(), Field.Store.YES));
                }
                else if(type.equals(JSONObject.class)){
                    addDocuments( (JSONObject)object.get(field) , doc);
                }
                else if(type.equals(JSONArray.class)){
                    addDocuments((JSONArray)object.get(field) , doc);
                }
            }
            try {
                indexWriter.addDocument(doc);
            } catch (IOException ex) {
                System.err.println("Error adding documents to the index. " +  ex.getMessage());
            }
        }
    }


    public void addDocuments(JSONArray jsonObjects,Document doc){
        for(JSONObject object : (List<JSONObject>) jsonObjects){
            for(String field : (Set<String>) object.keySet()){
                Class type = object.get(field).getClass();
                if(type.equals(String.class)){
                    doc.add(new StringField(field, (String)object.get(field), Field.Store.NO));
                }else if(type.equals(Long.class)){
                    doc.add(new LongPoint(field, (Long) object.get(field)));
                }else if(type.equals(Double.class)){
                    doc.add(new DoublePoint(field, (Double) object.get(field)));
                }else if(type.equals(Boolean.class)){
                    doc.add(new StringField(field, object.get(field).toString(), Field.Store.YES));
                }
                else if(type.equals(JSONObject.class)){
                    addDocuments( (JSONObject)object.get(field) , doc);
                }
                else if(type.equals(JSONArray.class)){
                    addDocuments((JSONArray)object.get(field) , doc);
                }
            }
        }
    }

    public void addDocuments(JSONObject object , Document doc){
            for(String field : (Set<String>) object.keySet()){
                Class type = object.get(field).getClass();
                if(type.equals(String.class)){
                    doc.add(new StringField(field, (String)object.get(field), Field.Store.NO));
                }else if(type.equals(Long.class)){
                    doc.add(new LongPoint(field, (Long) object.get(field)));
                }else if(type.equals(Double.class)){
                    doc.add(new DoublePoint(field, (Double) object.get(field)));
                }else if(type.equals(Boolean.class)){
                    doc.add(new StringField(field, object.get(field).toString(), Field.Store.YES));
                }else if(type.equals(Boolean.class)){
                    doc.add(new StringField(field, object.get(field).toString(), Field.Store.YES));
                }
                else if(type.equals(JSONObject.class)){
                    addDocuments( (JSONObject)object.get(field) , doc);
                }
                else if(type.equals(JSONArray.class)){
                    addDocuments((JSONArray)object.get(field) , doc);
                }
            }
        }


    /**
     * Write the document to the index and close it
     */
    public void finish(){
        try {
            indexWriter.commit();
            indexWriter.close();
        } catch (IOException ex) {
            System.err.println("We had a problem closing the index: " + ex.getMessage());
        }
    }


}
