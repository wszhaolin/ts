package com.baizhi.test;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class Test4 {
    @Test
    public void test() throws IOException {
        FSDirectory directory = FSDirectory.open(Paths.get("D:\\index\\02"));
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        Query query = new TermQuery(new Term("content","天"));
        TopDocs topDocs = indexSearcher.search(query, 10);
        System.out.println("符合条件的总记录数:"+topDocs.totalHits);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs) {
            System.out.println("文档的得分:"+scoreDoc.score);
            int docID = scoreDoc.doc;
            Document document = indexReader.document(docID);
            System.out.println(document.get("id") + " | " + document.get("title") + " | "+document.get("content"));
        }
    }
}
