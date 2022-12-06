package com.unab.catvirtual.catvirtualg24.sevice;

import com.unab.catvirtual.catvirtualg24.enitity.Book;
import com.unab.catvirtual.catvirtualg24.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> listBooks(){
        return bookRepository.findAll();
    }

    public List<Book> listBooksByAuthor(String authorName){
        return bookRepository.findByAuthor(authorName);
    }

}
