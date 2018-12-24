package com.baizhi.test;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class Test2 {
    @Test
    public void test() throws IOException {
        //指定索引数据的存储位置
        FSDirectory open = FSDirectory.open(Paths.get("D:\\index\\01"));
            //创建索引读入器
        IndexReader open1 = DirectoryReader.open(open);
        //创建检索器
        IndexSearcher indexSearcher = new IndexSearcher(open1);
        //指定检索的域的域名
        TermQuery termQuery = new TermQuery(new Term("content", "是"));
        //n表示 保留符合条件的前N条记录
        TopDocs search = indexSearcher.search(termQuery, 14);
        ScoreDoc[] scoreDocs = search.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            float score = scoreDoc.score;
            System.out.println("文档得分："+score);
            int doc = scoreDoc.doc;
            Document document = open1.document(doc);
            System.out.println("查询到的结果"+document.get("content"));
        }
        open1.close();
    }
}
