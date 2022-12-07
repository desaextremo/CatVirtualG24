package com.unab.catvirtual.catvirtualg24.controller;

import com.unab.catvirtual.catvirtualg24.enitity.Book;
import com.unab.catvirtual.catvirtualg24.sevice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Book queryBook(@PathVariable("id") String isbn){
        return bookService.queryBook(isbn);
    }

    @PostMapping("/new")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable("isbn") String id){
        bookService.deleteBook(id);
    }

    @GetMapping("/author/{author}")
    public List<Book> listBooksByAuthor(@PathVariable("author") String authorName){
        return bookService.listBooksByAuthor(authorName);
    }

    @GetMapping("/category/{category}")
    public List<Book> listBookByCategory(@PathVariable("category") String categoryName){
        return bookService.listBookByCategory(categoryName);
    }

    @GetMapping("/ind/{letter}")
    public List<Book> listBooksByLetter(@PathVariable("letter") String letter){
        return bookService.listBooksByLetter(letter);
    }

}
