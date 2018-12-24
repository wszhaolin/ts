package com.baizhi.controller;

import com.baizhi.entity.Poetries;
import com.baizhi.entity.Poets;
import com.baizhi.service.PoetriesService;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private PoetriesService poetriesService;
@RequestMapping("/findAll")
    public String findAll(String parse, Model model, String aaa,Integer pageNow) throws IOException, ParseException, InvalidTokenOffsetsException {
        FSDirectory fsDirectory = FSDirectory.open(Paths.get("D:\\index\\01"));
        IndexReader indexReader = DirectoryReader.open(fsDirectory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        QueryParser queryParser = new QueryParser(aaa, new IKAnalyzer());
        Query query=null;
        System.out.println(parse+aaa+pageNow);
        query = queryParser.parse(parse);
        TopDocs topDocs =null;
        int pageSize = 10;
        //如果当前页数是为空或者0，就指定页数为第一页
    if(pageNow == null || pageNow ==0){
        pageNow = 1;
    }
    //如果说当前页数是第一页就展示查到的数据
    if(pageNow == 1 || pageNow < 1){
        topDocs = indexSearcher.search(query, pageSize);
        //如果不是第一页，就必须先获取上一页的最后一条数据
    }else if(pageNow > 1){
        topDocs = indexSearcher.search(query, (pageNow - 1) * pageSize);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        ScoreDoc scoreDoc = scoreDocs[scoreDocs.length - 1];
        topDocs = indexSearcher.searchAfter(scoreDoc, query, pageSize);
    }
    //查询到的总条数
    int counts = topDocs.totalHits;
    //页面总页数
    Integer pageCounts = 0;

    if(counts % pageSize == 0){
        pageCounts = counts / pageSize;
    }else {
        pageCounts = counts / pageSize + 1;
    }
    // 创建高亮器对象
    Scorer scorer = new QueryScorer(query);
    // 使用自定义的高亮样式
    Formatter formatter = new SimpleHTMLFormatter("<span style=\"color:red\">","</span>");
    Highlighter highlighter = new Highlighter(formatter,scorer);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        ArrayList list=new ArrayList();
        for (ScoreDoc scoreDoc : scoreDocs) {
            Poetries poetries=new Poetries();
            Poets poets=new Poets();
            int docID = scoreDoc.doc;
            Document document = indexReader.document(docID);
            String id = document.get("id");
            //给title进行高亮赋值
            String title = highlighter.getBestFragment(new IKAnalyzer(), "content",document.get("title"));
            if(title!=null){
                poetries.setTitle(title);
            }else{
                poetries.setTitle(document.get("title"));
            }
            //给content进行高亮赋值
            String content = highlighter.getBestFragment(new StandardAnalyzer(), "content", document.get("content"));
            if(content!=null){
                poetries.setContent(content);
            }else{
                poetries.setContent(document.get("content"));
            }
            //给author进行高亮赋值
            String author = highlighter.getBestFragment(new IKAnalyzer(),"content",document.get("author"));
            if(author!=null){
                poets.setName(author);
                poetries.setPoets(poets);
            }else{
                poets.setName(document.get("author"));
                poetries.setPoets(poets);
            }
            poetries.setId(Integer.valueOf(id));
            list.add(poetries);
        }
        model.addAttribute("list",list);
        model.addAttribute("parse",parse);
        model.addAttribute("pageNow",pageNow);
        model.addAttribute("counts",counts);
        model.addAttribute("pageCounts",pageCounts);
        model.addAttribute("aaa",aaa);
        indexReader.close();
        return "ArreayList";
    }
}

