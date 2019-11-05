package Helloworld;

import com.lucene.demo.LuceneIndexWriter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class jsonTest_1 {

    static final String INDEX_PATH = "index_dir";


    @Test
    public void testQueryLucene() throws IOException, ParseException {
        Directory indexDirectory = FSDirectory.open(new File(INDEX_PATH));
        IndexReader indexReader = DirectoryReader.open(indexDirectory);
        final IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        Term t = new Term("name", "Shirt");
        Query query = new TermQuery(t);

        TopDocs topDocs = indexSearcher.search(query, 10);
        assertEquals(5, topDocs.totalHits);

    }

    @Test
    public void testQueryLucene1() throws IOException, ParseException {
        Directory indexDirectory = FSDirectory.open(new File(INDEX_PATH));
        IndexReader indexReader = DirectoryReader.open(indexDirectory);
        final IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        Term t = new Term("name", "Apple Book");
        Query query = new TermQuery(t);

        TopDocs topDocs = indexSearcher.search(query, 10);
        assertEquals(5, topDocs.totalHits);

    }

    @Test
    public void testQueryLucene2() throws IOException, ParseException {
        Directory indexDirectory = FSDirectory.open(new File(INDEX_PATH));
        IndexReader indexReader = DirectoryReader.open(indexDirectory);
        final IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);

        Query q = null;
        try {
            q = new QueryParser(Version.LUCENE_40, "name", analyzer).parse("Shirt");
        } catch (org.apache.lucene.queryparser.classic.ParseException e) {
            e.printStackTrace();
        }

        TopDocs topDocs = indexSearcher.search(q, 10);
        assertEquals(4, topDocs.totalHits);
        ScoreDoc[] hits = topDocs.scoreDocs;


        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = indexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("name") + "\t" + d.get("id")+ "\t" + d.get("type"));
        }

    }


}
