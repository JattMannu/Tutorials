package Helloworld;

import com.lucene.demo.searcher.MyIndexSearcher;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.bson.*;
import org.bson.io.ByteBufferBsonInput;
import org.bson.io.OutputBuffer;
import org.junit.Before;
import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class apiTest {

    static final String INDEX_PATH = "index_dir";
    MyIndexSearcher myIndexSearcher;

    @Before
    public void before() throws IOException {
        myIndexSearcher = new MyIndexSearcher(new File(INDEX_PATH));
    }

    /*
    Notes :
    http://www.lucenetutorial.com/lucene-query-builder.html
     */

    @Test
    public void testQueryLucene_spec_1() throws IOException, ParseException {


        TopDocs topDocs = myIndexSearcher.search(new QueryParser("root", new StandardAnalyzer()) {
        }.parse("root.details.max_power:[500 TO 909] AND root.details.type:Scepter AND Vision"));

        ScoreDoc[] hits = topDocs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = myIndexSearcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("root.name") + "\t" + d.get("root.id") + "\t" + d.get("root.type") + "\t" + d.get("root.details.max_power"));
            this.getItem(d.get("root.id"));
        }
    }

    private BsonDocument getItem(String itemId){

        String https_url = String.format("https://api.guildwars2.com/v2/items/%s",itemId);
        URL url;
        try {

            url = new URL(https_url);
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            BufferedReader br = new BufferedReader(isr);
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();

            while ((inputLine = br.readLine()) != null) {
                stringBuilder.append(inputLine);
            }

            br.close();

            return BsonDocument.parse(stringBuilder.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new BsonDocument();
    }







}
