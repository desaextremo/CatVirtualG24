package com.unab.catvirtual.catvirtualg24.sevice;

import com.unab.catvirtual.catvirtualg24.enitity.Book;
import com.unab.catvirtual.catvirtualg24.enitity.BookThree;
import com.unab.catvirtual.catvirtualg24.repository.BookThreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookThreeService {
    @Autowired
    private BookThreeRepository bookThreeRepository;

    public List<BookThree> listBook(){
        return bookThreeRepository.findAll();
    }

    public BookThree queryBook(String isbn){
        BookThree BookThree;
        Optional<BookThree> optional =  bookThreeRepository.findById(isbn);

        if(!optional.isEmpty()){
            BookThree = optional.get();
        }else{
            BookThree = null;
        }
        return BookThree;
    }

    public BookThree addBook(BookThree BookThree){
        BookThree BookThreeTwo;
        Optional<BookThree> optional =  bookThreeRepository.findById(BookThree.getIsbn());

        if(optional.isEmpty()) return bookThreeRepository.insert(BookThree);
        else return null;
    }

    public BookThree saveBook(BookThree BookThree){
        //1 Buscamos si el libro existe y recuperamos toda su información
        Optional<BookThree> opcional = bookThreeRepository.findById(BookThree.getIsbn());
        //el libro existe
        if (!opcional.isEmpty()){
            BookThree libroBD = opcional.get();
            //2 comparamos si los valores actuales son diferentes a los valores del libro recibido como parametro

            if (BookThree.getCategory()!=null) libroBD.setCategory(BookThree.getCategory());
            if (BookThree.getAuthor()!=null) libroBD.setAuthor(BookThree.getAuthor());
            if (BookThree.getDescription()!=null) libroBD.setDescription(BookThree.getDescription());
            if (BookThree.getTitle()!=null) libroBD.setTitle(BookThree.getTitle());
            if(BookThree.getPages()!=0) libroBD.setPages(BookThree.getPages());
            if(BookThree.getPrice()!=0) libroBD.setPrice(BookThree.getPrice());
            if(BookThree.getYear()!=0) libroBD.setYear(BookThree.getYear());
            if(BookThree.isSeleccionado()) libroBD.setSeleccionado(BookThree.isSeleccionado());
            if(BookThree.getDescription()!=null) libroBD.setDescription(BookThree.getDescription());

            return bookThreeRepository.save(libroBD);
        }else{ //el libro no existe
            return null;
        }
    }

    public void deleteBook(String id){
        bookThreeRepository.deleteById(id);
    }

    public List<BookThree> findBookRange(long priceMin, long priceMax){
        return bookThreeRepository.findBookRange(priceMin,priceMax);
    }

    public List<BookThree> findByLetter(String letter){
        return bookThreeRepository.findByLetter(letter);
    }
}
