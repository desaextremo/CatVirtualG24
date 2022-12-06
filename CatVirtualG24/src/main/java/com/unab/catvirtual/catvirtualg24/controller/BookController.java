package com.unab.catvirtual.catvirtualg24.controller;

import com.unab.catvirtual.catvirtualg24.enitity.Book;
import com.unab.catvirtual.catvirtualg24.sevice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/all")
    public List<Book> listBooks(){
        return bookService.listBooks();
    }

    @GetMapping("/{author}")
    public List<Book> listBooksByAuthor(@PathVariable("author") String authorName){
        return bookService.listBooksByAuthor(authorName);
    }

}
