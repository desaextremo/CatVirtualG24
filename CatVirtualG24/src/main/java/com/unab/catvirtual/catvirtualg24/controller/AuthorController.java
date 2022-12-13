package com.unab.catvirtual.catvirtualg24.controller;

import com.unab.catvirtual.catvirtualg24.enitity.Author;
import com.unab.catvirtual.catvirtualg24.enitity.Category;
import com.unab.catvirtual.catvirtualg24.repository.AuthorRepository;
import com.unab.catvirtual.catvirtualg24.sevice.AuthorService;
import com.unab.catvirtual.catvirtualg24.sevice.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/all")
    public List<Author> listAuthors(){
        return authorService.listAuthors();
    }

    @GetMapping("/{id}")
    public Author queryAuthor(@PathVariable("id") String id){
        return authorService.queryAuthor(id);
    }

    @PostMapping("/new")
    public Author addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @PutMapping("/save")
    public Author saveBook(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") String id){
        authorService.deleteAuthor(id);
    }
}
