package Helloworld;

import com.lucene.demo.LuceneIndexWriter;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import static org.junit.Assert.*;

public class jsonTest {

    static final String INDEX_PATH = "indexDir";
    static final String JSON_FILE_PATH = "/test.json";

    @Test
    public void testWriteIndex(){
        try {
            LuceneIndexWriter lw = new LuceneIndexWriter(INDEX_PATH, JSON_FILE_PATH);
            lw.createIndex();

            //Check the index has been created successfully
            Directory indexDirectory = FSDirectory.open(new File(INDEX_PATH));
            IndexReader indexReader = DirectoryReader.open(indexDirectory);

            int numDocs = indexReader.numDocs();
            assertEquals(5, numDocs);

            for ( int i = 0; i < numDocs; i++)
            {
                Document document = indexReader.document( i);
                System.out.println( "d=" +document);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @org.junit.Test
    public void testQueryLucene() throws IOException, ParseException {
        Directory indexDirectory = FSDirectory.open(new File(INDEX_PATH));
        IndexReader indexReader = DirectoryReader.open(indexDirectory);
        final IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        Term t = new Term("author", "Steve Jobs");
        Query query = new TermQuery(t);

        TopDocs topDocs = indexSearcher.search(query, 10);
        assertEquals(5, topDocs.totalHits);

    }

    @org.junit.Test
    public void testQueryLucene1() throws IOException, ParseException {
        Directory indexDirectory = FSDirectory.open(new File(INDEX_PATH));
        IndexReader indexReader = DirectoryReader.open(indexDirectory);
        final IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        Term t = new Term("name", "Apple Book");
        Query query = new TermQuery(t);

        TopDocs topDocs = indexSearcher.search(query, 10);
        assertEquals(5, topDocs.totalHits);

    }

}
