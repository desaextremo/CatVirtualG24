package com.unab.catvirtual.catvirtualg24.repository;

import com.unab.catvirtual.catvirtualg24.enitity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,String> {
}
