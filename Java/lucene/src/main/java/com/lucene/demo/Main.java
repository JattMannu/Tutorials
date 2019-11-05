package com.lucene.demo;

import com.lucene.demo.indexer.JsonIndexWriter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String... args)throws IOException, ParseException {

        String INDEX_PATH = "index_dir";
        String JSON_DUMPS= "/data_dump/";

        try {
            JsonIndexWriter lw = new JsonIndexWriter(INDEX_PATH, JSON_DUMPS);

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
