package com.unab.catvirtual.catvirtualg24.controller;

import com.unab.catvirtual.catvirtualg24.entity.BookThree;
import com.unab.catvirtual.catvirtualg24.entity.dto.BookThreeDto;
import com.unab.catvirtual.catvirtualg24.sevice.BookThreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookThreeController {
    @Autowired
    BookThreeService bookThreeService;

    @GetMapping("/all")
    public List<BookThree> listBooks(){
        return bookThreeService.listBook();
    }

    @GetMapping("/{id}")
    public BookThree queryBook(@PathVariable("id") String isbn){
        return bookThreeService.queryBook(isbn);
    }

    @PostMapping("/new")
    public BookThree addBook(@RequestBody BookThreeDto bookDto){
        return bookThreeService.addBook(bookDto);
    }

    @PutMapping("/save")
    public BookThree saveBook(@RequestBody BookThreeDto bookDto){
        return bookThreeService.saveBook(bookDto);
    }

    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable("isbn") String id){
        bookThreeService.deleteBook(id);
    }

    @GetMapping("/init/{letter}")
    public List<BookThree> findByLetter(@PathVariable("letter") String letter){
        return bookThreeService.findByLetter(letter);
    }

    @GetMapping("/price/{inferior}/{superior}")
    public List<BookThree> findBookRange(@PathVariable("inferior") long priceMin, @PathVariable("superior") long priceMax){
        return bookThreeService.findBookRange(priceMin,priceMax);
    }
}
