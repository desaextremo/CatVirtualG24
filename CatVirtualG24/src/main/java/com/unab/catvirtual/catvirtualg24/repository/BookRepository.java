package com.unab.catvirtual.catvirtualg24.repository;

import com.unab.catvirtual.catvirtualg24.enitity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {
    public List<Book> findByCategory(String categoryNme);

    public List<Book> findByAuthor(String authorName);

    public List<Book> findByTitleStartsWith(String letter);
}
