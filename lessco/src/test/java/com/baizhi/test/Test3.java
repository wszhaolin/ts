package com.baizhi.test;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class Test3 {
    @Test
    public void test() throws IOException {
        //获取索引存放位置
        FSDirectory open = FSDirectory.open(Paths.get("D:\\index\\02"));
        //创建索引写入器
        StandardAnalyzer standardAnalyzer = new StandardAnalyzer();
        //创建标准分析器
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(standardAnalyzer);
        IndexWriter indexWriter = new IndexWriter(open,indexWriterConfig);
        File file = new File("D:\\files");
        File[] files = file.listFiles();
        Document document=null;
        int id=0;
        for (File file1 : files) {
            document=new Document();
            document.add(new IntField("id",id, Field.Store.YES));
            document.add(new StringField("title",file1.getName(),Field.Store.YES));
            document.add(new TextField("content",new FileReader(file1)));
            id ++;
            indexWriter.addDocument(document);
        }
        indexWriter.commit();
        indexWriter.close();
    }
}
