package com.lucene.demo.searcher;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.complexPhrase.ComplexPhraseQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class MyIndexSearcher {

    private Directory indexDirectory;
    private IndexReader indexReader;
    private final IndexSearcher indexSearcher;
    private StandardAnalyzer analyzer;

    private final String DEFAULT_FIELD = "root:name";
    private final int DEFAULT_RESULT_COUNT = 10;

    private final Version version = Version.LATEST;

    public MyIndexSearcher(File indexFile) throws IOException {
        this.indexDirectory = FSDirectory.open(indexFile.toPath());
        this.indexReader = DirectoryReader.open(indexDirectory);
        this.indexSearcher = new IndexSearcher(indexReader);    //Not good
        this.analyzer = new StandardAnalyzer();          //Not good
    }

    public TopDocs search(String query) throws IOException, ParseException {
        return this.search(DEFAULT_FIELD, query);
    }

    public TopDocs search(String fieldName, String query) throws IOException, ParseException {
        return this.search(fieldName, query, DEFAULT_RESULT_COUNT);
    }

    public TopDocs search(String fieldName, String query, int resultCount) throws IOException, ParseException {
        return this.indexSearcher.search(new QueryParser(fieldName, analyzer).parse(query), resultCount);
    }

    public TopDocs search(Query query) throws IOException, ParseException {
        return this.indexSearcher.search(query,DEFAULT_RESULT_COUNT);
    }

    public Document doc(int docId) throws IOException {
        return this.indexSearcher.doc(docId);
    }

}
