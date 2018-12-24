package com.baizhi.test;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queries.TermsQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class Test5 {
    @Test
    public void test() throws IOException {
        FSDirectory open = FSDirectory.open(Paths.get("D:\\index\\01"));
        IndexReader open1 = DirectoryReader.open(open);
        IndexSearcher indexSearcher = new IndexSearcher(open1);
        Query query = new TermsQuery(new Term("content", "是"));
        TopDocs topDocs=indexSearcher.search(query,14);
        System.out.println("符合条件的总记录数："+topDocs.totalHits);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            System.out.println("文档得分："+scoreDoc.score);
            int doc = scoreDoc.doc;
            Document document = open1.document(doc);
            System.out.println(document.get("id")+"|"+document.get("title")+"|"+document.get("content"));
        }
    }
}
