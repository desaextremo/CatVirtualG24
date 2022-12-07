package com.unab.catvirtual.catvirtualg24.sevice;

import com.unab.catvirtual.catvirtualg24.enitity.Book;
import com.unab.catvirtual.catvirtualg24.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> listBooks(){
        return bookRepository.findAll();
    }

    public Book queryBook(String isbn){
        Book book;
        Optional<Book> optional =  bookRepository.findById(isbn);

        if(!optional.isEmpty()){
            book = optional.get();
        }else{
            book = null;
        }
        return book;
    }

    public Book addBook(Book book){
        Book bookTwo;
        Optional<Book> optional =  bookRepository.findById(book.getIsbn());

        if(optional.isEmpty()) return bookRepository.insert(book);
        else return null;
    }

    public void deleteBook(String id){
        bookRepository.deleteById(id);
    }

    public List<Book> listBooksByAuthor(String authorName){
        return bookRepository.findByAuthor(authorName);
    }

    public List<Book> listBookByCategory(String categoryName){
        return bookRepository.findByCategory(categoryName);
    }

    public List<Book> listBooksByLetter(String letter){
        return bookRepository.findByTitleStartsWith(letter);
    }
}
