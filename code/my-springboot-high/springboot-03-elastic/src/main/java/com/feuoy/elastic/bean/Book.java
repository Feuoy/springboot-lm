package com.feuoy.elastic.bean;

import org.springframework.data.elasticsearch.annotations.Document;


/*用springData elasticSearch*/


// elasticSearch注解：索引/类型
@Document(indexName = "feuoy", type = "book")
public class Book {


    private Integer id;
    private String bookName;
    private String author;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
