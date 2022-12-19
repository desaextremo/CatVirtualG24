package com.unab.catvirtual.catvirtualg24.controller;

import com.unab.catvirtual.catvirtualg24.entity.Book;
import com.unab.catvirtual.catvirtualg24.service.BookService;
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

    @PutMapping("/save")
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
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

    @GetMapping("/init/{letter}")
    public List<Book> findByLetter(@PathVariable("letter") String letter){
        return bookService.findByLetter(letter);
    }

    @GetMapping("/price/{inferior}/{superior}")
    public List<Book> findBookRange(@PathVariable("inferior") long priceMin, @PathVariable("superior") long priceMax){
        return bookService.findBookRange(priceMin,priceMax);
    }

    @GetMapping("/end/{letter}")
    public List<Book> findByTitleEndingWith(@PathVariable("letter") String letter){
        return bookService.findByTitleEndingWith(letter);
    }

    @GetMapping("/endtwo/{letter}")
    public List<Book> findBooksEndWith(@PathVariable("letter") String letter){
        return bookService.findBooksEndWith(letter);
    }

    @GetMapping("/contain/{letter}")
    public List<Book> findByTitleContains(@PathVariable("letter") String text){
        return bookService.findByTitleContains(text);
    }

    @GetMapping("/containtwo/{letter}")
    public List<Book> findBooksContain(@PathVariable("letter") String text){
        return bookService.findBooksContain(text);
    }
}
