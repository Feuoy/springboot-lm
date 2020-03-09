package com.feuoy.elastic.repository;

import com.feuoy.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


/*用springData elasticSearch*/


// 实现ElasticsearchRepository<T, ID>
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {


    // 支持自定义方法，只需要写方法名，已经有实现；参照https://docs.spring.io/spring-data/elasticsearch/docs/3.0.6.RELEASE/reference/html/
    // Like模糊查询
    public List<Book> findByBookNameLike(String bookName);


}
