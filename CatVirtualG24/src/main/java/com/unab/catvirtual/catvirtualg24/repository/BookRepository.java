package com.unab.catvirtual.catvirtualg24.repository;

import com.unab.catvirtual.catvirtualg24.enitity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {
    public List<Book> findByCategory(String categoryNme);

    public List<Book> findByAuthor(String authorName);

    public List<Book> findByTitleStartsWith(String letter);

    @Query(value = "{title: {$regex : /^?0/i}}", sort="{title:1}")
    public List<Book> findByLetter(String letter);

    public List<Book> findByTitleEndingWith(String letter);

    @Query(value = "{title: {$regex : /?0$/i}}")
    public List<Book> findBooksEndWith(String letter);

    public List<Book> findByTitleContains(String text);

    @Query(value = "{title: {$regex : /?0/i}}", sort="{title:1}")
    public List<Book> findBooksContain(String text);

    @Query(value = "{price : { $lt: ?0}}", sort= "{price: -1}")
    public List<Book> findBookLess(long price);

    @Query(value = "{price : { $gt: ?0}}", sort= "{price: -1}")
    public List<Book> findBookGreather(long price);

    @Query(value = "{price : { $gte: ?0 , $lte: ?1}}", sort= "{price: -1}")
    public List<Book> findBookRange(long priceMin, long priceMax);

}
