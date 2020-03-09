package com.feuoy.elastic;

import com.feuoy.elastic.bean.Article;
import com.feuoy.elastic.bean.Book;
import com.feuoy.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
class Springboot03ElasticApplicationTests {


    /*用jest*/


    @Autowired
    JestClient jestClient;


    // 测试索引
    @Test
    public void contextLoads() {


        // http://127.0.0.1:9200/feuoy/news/1


        // 1、给Es中索引（动词：保存）一个文档；
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("zhangsan");
        article.setContent("Hello World");


        // 构建一个索引功能：索引feuoy/类型news
        Index index = new Index.Builder(article)
                .index("feuoy").type("news")
                .build();


        try {
            // 执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 测试搜索
    @Test
    public void search() {


        // 更多操作：https://github.com/searchbox-io/Jest/tree/master/jest


        // 查询表达式（名词：一种语言）
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";


        // 构建搜索功能：在索引feuoy/类型news下搜索
        Search search = new Search.Builder(json)
                .addIndex("feuoy").addType("news")
                .build();


        // 执行
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    /*用springData elasticSearch*/


    @Autowired
    BookRepository bookRepository;


    @Test
    public void test02(){


        // http://127.0.0.1:9200/feuoy/book/_search


//		Book book = new Book();
//		book.setId(1);
//		book.setBookName("西游记");
//		book.setAuthor("吴承恩");
//		bookRepository.index(book);


        // 查有几个有“游”的文档
        for (Book book : bookRepository.findByBookNameLike("游")) {
            System.out.println(book);
        }
    }
}
