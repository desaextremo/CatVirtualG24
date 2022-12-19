package com.unab.catvirtual.catvirtualg24.sevice;

import com.unab.catvirtual.catvirtualg24.entity.Book;
import com.unab.catvirtual.catvirtualg24.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

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

    public Book saveBook(Book book){
        //1 Buscamos si el libro existe y recuperamos toda su información
        Optional<Book> opcional = bookRepository.findById(book.getIsbn());
        //el libro existe
        if (!opcional.isEmpty()){
            Book libroBD = opcional.get();
            //2 comparamos si los valores actuales son diferentes a los valores del libro recibido como parametro

            if (book.getCategory()!=null) libroBD.setCategory(book.getCategory());
            if (book.getAuthor()!=null) libroBD.setAuthor(book.getAuthor());
            if (book.getDescription()!=null) libroBD.setDescription(book.getDescription());
            if (book.getTitle()!=null) libroBD.setTitle(book.getTitle());
            if(book.getPages()!=0) libroBD.setPages(book.getPages());
            if(book.getPrice()!=0) libroBD.setPrice(book.getPrice());
            if(book.getYear()!=0) libroBD.setYear(book.getYear());
            if(book.isSeleccionado()) libroBD.setSeleccionado(book.isSeleccionado());
            if(book.getDescription()!=null) libroBD.setDescription(book.getDescription());

            return bookRepository.save(libroBD);
        }else{ //el libro no existe
            return null;
        }
    }

    public void deleteBook(String id){
        bookRepository.deleteById(id);
    }

    public List<Book> listBooksByAuthor(String authorId){
        Query query = new Query();
        Criteria dateCriteria = Criteria.where("author.id").is(authorId);

        query.addCriteria(dateCriteria);
        List<Book> books = mongoTemplate.find(query, Book.class);

        return books;
    }

    public List<Book> listBookByCategory(String categoryId){
        Query query = new Query();
        Criteria dateCriteria = Criteria.where("category.id").is(categoryId);

        query.addCriteria(dateCriteria);
        List<Book> books = mongoTemplate.find(query, Book.class);

        return books;
    }

    public List<Book> listBooksByLetter(String letter){

        return bookRepository.findByTitleStartsWithOrderByTitleAsc(letter);
    }

    public List<Book> findByLetter(String letter){
        return bookRepository.findByLetter(letter);
    }

    public List<Book> findByTitleEndingWith(String letter){
        return bookRepository.findByTitleEndingWithOrderByTitleAsc(letter);
    }

    public List<Book> findBooksEndWith(String letter){
        return bookRepository.findBooksEndWith(letter);
    }

    public List<Book> findByTitleContains(String text){
        return bookRepository.findByTitleContainsOrderByTitleAsc(text);
    }

    public List<Book> findBooksContain(String text){
        return bookRepository.findBooksContain(text);
    }

    public List<Book> findBookRange(long priceMin, long priceMax){
        return bookRepository.findBookRange(priceMin,priceMax);
    }

}
