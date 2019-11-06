package Helloworld;

import com.lucene.demo.searcher.MyIndexSearcher;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.complexPhrase.ComplexPhraseQueryParser;
import org.apache.lucene.queryparser.xml.QueryBuilder;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.util.NamedList;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class jsonTest_1 {

    static final String INDEX_PATH = "index_dir";


    public void testQueryLucene() throws IOException, ParseException {
        Directory indexDirectory = FSDirectory.open(new File(INDEX_PATH).toPath());
        IndexReader indexReader = DirectoryReader.open(indexDirectory);
        final IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        Term t = new Term("root.type", "MiniPet");
        Query query = new TermQuery(t);

        TopDocs topDocs = indexSearcher.search(query, 10);
        assertEquals(1, topDocs.totalHits.value);

    }


    @Test
    public void testQueryLucene2() throws IOException, ParseException {
        Directory indexDirectory = FSDirectory.open(new File(INDEX_PATH).toPath());
        IndexReader indexReader = DirectoryReader.open(indexDirectory);
        final IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        StandardAnalyzer analyzer = new StandardAnalyzer();

        Query q = null;
        try {
            q = new QueryParser("root.name", analyzer).parse("Shirt");
        } catch (org.apache.lucene.queryparser.classic.ParseException e) {
            e.printStackTrace();
        }

        TopDocs topDocs = indexSearcher.search(q, 10);
        assertEquals(4, topDocs.totalHits.value);
        ScoreDoc[] hits = topDocs.scoreDocs;


        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = indexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type"));
        }

    }


    @Test
    public void testQueryLucene_range() throws IOException, ParseException {
        Directory indexDirectory = FSDirectory.open(new File(INDEX_PATH).toPath());
        IndexReader indexReader = DirectoryReader.open(indexDirectory);
        final IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        StandardAnalyzer analyzer = new StandardAnalyzer();

        Query q = null;
        try {
            q = new QueryParser("root.name", analyzer).parse("[Shir TO Shirt]");
        } catch (org.apache.lucene.queryparser.classic.ParseException e) {
            e.printStackTrace();
        }

        TopDocs topDocs = indexSearcher.search(q, 10);
        assertEquals(6, topDocs.totalHits.value);
        ScoreDoc[] hits = topDocs.scoreDocs;


        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = indexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type"));
        }

    }

    @Test
    public void testQueryLucene_fuzzy() throws IOException, ParseException {
        Directory indexDirectory = FSDirectory.open(new File(INDEX_PATH).toPath());
        IndexReader indexReader = DirectoryReader.open(indexDirectory);
        final IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        StandardAnalyzer analyzer = new StandardAnalyzer();

        Query q = null;
        try {
            q = new QueryParser("root.name", analyzer).parse("//Shirt~");
        } catch (org.apache.lucene.queryparser.classic.ParseException e) {
            e.printStackTrace();
        }

        TopDocs topDocs = indexSearcher.search(q, 10);
        ScoreDoc[] hits = topDocs.scoreDocs;


        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = indexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type"));
        }

    }


    @Test
    public void testQueryLucene_Proximity() throws IOException, ParseException {
        Directory indexDirectory = FSDirectory.open(new File(INDEX_PATH).toPath());
        IndexReader indexReader = DirectoryReader.open(indexDirectory);
        final IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        StandardAnalyzer analyzer = new StandardAnalyzer();

        Query q = null;
        try {
            q = new QueryParser("root.name", analyzer).parse("Sharp~10");
        } catch (org.apache.lucene.queryparser.classic.ParseException e) {
            e.printStackTrace();
        }

        TopDocs topDocs = indexSearcher.search(q, 10);
        //assertEquals(6, topDocs.totalHits);
        ScoreDoc[] hits = topDocs.scoreDocs;


        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = indexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type"));
        }

    }

    @Test
    public void testQueryLucene_Boosting() throws IOException, ParseException {
        Directory indexDirectory = FSDirectory.open(new File(INDEX_PATH).toPath());
        IndexReader indexReader = DirectoryReader.open(indexDirectory);
        final IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        StandardAnalyzer analyzer = new StandardAnalyzer();

        Query q = null;
        try {
            q = new QueryParser("root.name", analyzer).parse("Cherry^4 Shir~");
        } catch (org.apache.lucene.queryparser.classic.ParseException e) {
            e.printStackTrace();
        }

        TopDocs topDocs = indexSearcher.search(q, 10);
        //assertEquals(6, topDocs.totalHits);
        ScoreDoc[] hits = topDocs.scoreDocs;


        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = indexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type"));
        }

    }


    @Test
    public void testQueryLucene_free() throws IOException, org.apache.lucene.queryparser.classic.ParseException {
        MyIndexSearcher myIndexSearcher = new MyIndexSearcher(new File(INDEX_PATH));
        TopDocs topDocs = myIndexSearcher.search("root.game_types", "Wvw");

        ScoreDoc[] hits = topDocs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = myIndexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type")+ "\t" + d.get("root.details.max_power"));
        }

    }

    @Test
    public void testQueryLucene_free1() throws IOException, org.apache.lucene.queryparser.classic.ParseException {
        MyIndexSearcher myIndexSearcher = new MyIndexSearcher(new File(INDEX_PATH));

        //TopDocs topDocs = myIndexSearcher.search(new ComplexPhraseQueryParser("root.details.max_power", new StandardAnalyzer()).parse("[500 TO 909]"));
        //TopDocs topDocs = myIndexSearcher.search(NumericRangeQuery.newIntRange("root.details.max_power", 500, 909, true, true));

        TopDocs topDocs = myIndexSearcher.search(IntPoint.newRangeQuery("root.details.max_power", 500, 909));


        ScoreDoc[] hits = topDocs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = myIndexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type")+ "\t" + d.get("root.details.max_power"));
        }

    }



    @Test
    public void testQueryLucene_free2() throws IOException, org.apache.lucene.queryparser.classic.ParseException {
        MyIndexSearcher myIndexSearcher = new MyIndexSearcher(new File(INDEX_PATH));

        TopDocs topDocs = myIndexSearcher.search(new ComplexPhraseQueryParser("root.details.max_power", new StandardAnalyzer()).parse("[500 TO 909]"));
        //TopDocs topDocs = myIndexSearcher.search(NumericRangeQuery.newIntRange("root.details.max_power", 500, 909, true, true));

        ScoreDoc[] hits = topDocs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = myIndexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type")+ "\t" + d.get("root.details.max_power"));
        }

    }


    @Test
    public void testQueryLucene_free3() throws IOException, org.apache.lucene.queryparser.classic.ParseException {
        MyIndexSearcher myIndexSearcher = new MyIndexSearcher(new File(INDEX_PATH));
        TopDocs topDocs = myIndexSearcher.search("root", "Only one mini ma");

        ScoreDoc[] hits = topDocs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = myIndexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type")+ "\t" + d.get("root.details.max_power"));
        }

    }


    @Test
    public void testQueryLucene_inject_1() throws IOException, org.apache.lucene.queryparser.classic.ParseException {
        MyIndexSearcher myIndexSearcher = new MyIndexSearcher(new File(INDEX_PATH));
        //TopDocs topDocs = myIndexSearcher.search(new ComplexPhraseQueryParser("root.details.infix_upgrade.attributes.attribute.power", new StandardAnalyzer()).parse("[1 TO 909]"));

        TopDocs topDocs = myIndexSearcher.search(IntPoint.newRangeQuery("root.details.infix_upgrade.attributes.attribute.power", 251, 300));

        ScoreDoc[] hits = topDocs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = myIndexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type")+ "\t" + d.get("root.details.max_power"));

        }

    }

    @Test
    public void testQueryLucene_json_1() throws IOException, org.apache.lucene.queryparser.classic.ParseException{
        MyIndexSearcher myIndexSearcher = new MyIndexSearcher(new File(INDEX_PATH));

        TopDocs topDocs = myIndexSearcher.search(new QueryParser("root.details.max_power", new StandardAnalyzer()) {
        }.parse("root:Shirt"));
        //TopDocs topDocs = myIndexSearcher.search(NumericRangeQuery.newIntRange("root.details.max_power", 500, 909, true, true));

        ScoreDoc[] hits = topDocs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = myIndexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type")+ "\t" + d.get("root.details.max_power"));
        }
    }

    @Test
    public void testQueryLucene_json_2() throws IOException, org.apache.lucene.queryparser.classic.ParseException{
        MyIndexSearcher myIndexSearcher = new MyIndexSearcher(new File(INDEX_PATH));

        TopDocs topDocs = myIndexSearcher.search(new QueryParser("root.details.max_power", new StandardAnalyzer()) {
        }.parse("root.details.max_power:[500 TO 909]"));
        //TopDocs topDocs = myIndexSearcher.search(NumericRangeQuery.newIntRange("root.details.max_power", 500, 909, true, true));

        ScoreDoc[] hits = topDocs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = myIndexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type")+ "\t" + d.get("root.details.max_power"));
        }
    }


    @Test
    public void testQueryLucene_spec_1() throws IOException, org.apache.lucene.queryparser.classic.ParseException{

        // http://www.lucenetutorial.com/lucene-query-builder.html

        MyIndexSearcher myIndexSearcher = new MyIndexSearcher(new File(INDEX_PATH));

        TopDocs topDocs = myIndexSearcher.search(new QueryParser("root.details.max_power", new StandardAnalyzer()) {
        }.parse("root.details.max_power:[500 TO 909] AND root.details.type:Scepter"));
        //TopDocs topDocs = myIndexSearcher.search(NumericRangeQuery.newIntRange("root.details.max_power", 500, 909, true, true));

        ScoreDoc[] hits = topDocs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = myIndexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type")+ "\t" + d.get("root.details.max_power"));
        }
    }


}
