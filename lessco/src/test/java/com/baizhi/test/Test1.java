package com.baizhi.test;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class Test1 {
    @Test
    public void test1() throws IOException {
        //指定索引的存储位置
        FSDirectory open = FSDirectory.open(Paths.get("D:\\index\\01"));
        //创建索引写入器,创建标准的分析器对象
        StandardAnalyzer standardAnalyzer = new StandardAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(standardAnalyzer);
        IndexWriter indexWriter = new IndexWriter(open,indexWriterConfig);
        //创建文档对象
        Document indexableFields = new Document();
        //对文档进行初始化
        indexableFields.add(new TextField("content","梦里不知身是客是耶非耶化为蝴蝶",Field.Store.YES));
        //针对文档生成索引数据
        indexWriter.addDocument(indexableFields);
        indexWriter.commit();
        indexWriter.close();
    }
}
