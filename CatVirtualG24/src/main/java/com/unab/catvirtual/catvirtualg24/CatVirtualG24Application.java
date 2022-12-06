package com.unab.catvirtual.catvirtualg24;

import com.unab.catvirtual.catvirtualg24.enitity.Book;
import com.unab.catvirtual.catvirtualg24.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CatVirtualG24Application implements CommandLineRunner {
    //Atributo de tipo Repositorio para administra datos de los libros
    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(CatVirtualG24Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //borrado de datos
        //bookRepository.deleteAll();

        /*
        //Crear Libros
        Book oneBook = new Book();
        Book twoBook = new Book("NOVELAS");
        Book treeBook = new Book("NOVELAS","CIEN AÑOS DE SOLEDAD");
        Book fourBook = new Book("NOVELAS","CRÓNICA DE UNA MUERTE ANUNCIADA","GABRIEL GARCIA MARQUEZ");

        bookRepository.save(oneBook);
        bookRepository.save(twoBook);
        bookRepository.save(treeBook);
        bookRepository.save(fourBook);

        bookRepository.insert(oneBook);

        bookRepository.insert(twoBook);
        bookRepository.insert(treeBook);
        bookRepository.insert(fourBook);

        Book oneBook = Book.builder().build(); //new Book()
        Book twoBook = Book.builder().category("NOVELAS").build();   //new Book("NOVELAS");
        Book treeBook = Book.builder().category("NOVELAS").title("CIEN AÑOS DE SOLEDAD").build();//new Book("NOVELAS","CIEN AÑOS DE SOLEDAD");
        Book fourBook = Book.builder().category("NOVELAS").title("CRÓNICA DE UNA MUERTE ANUNCIADA").author("GABRIEL GARCIA MARQUEZ").build();//new Book("NOVELAS","CRÓNICA DE UNA MUERTE ANUNCIADA","GABRIEL GARCIA MARQUEZ");
        Book sixBook = Book.builder().title("UN LIBRO").pages(200).price(45000).build();//titulo, paginas,precio
        bookRepository.saveAll(
                List.of(oneBook,twoBook,treeBook,fourBook,sixBook)
        );


        bookRepository.saveAll(
            List.of(Book.builder().build(),
                    Book.builder().category("NOVELAS").build(),
                    Book.builder().category("NOVELAS").title("CIEN AÑOS DE SOLEDAD").build(),
                    Book.builder().category("NOVELAS").title("CRÓNICA DE UNA MUERTE ANUNCIADA").author("GABRIEL GARCIA MARQUEZ").build(),
                    Book.builder().title("UN LIBRO").pages(200).price(45000).build()
                    )
        );

         */

        //Listar datos de la bd
        List<Book> catalogo =  bookRepository.findAll();

        System.out.println("Listado de libros");
        for (Book book:catalogo) {
            System.out.println(book);
        }

        //Listar datos de la bd -- CUENTOS
        catalogo =  bookRepository.findByCategory("CUENTOS");

        System.out.println("Listado de libros CATEGORIA: CUENTOS");
        for (Book book:catalogo) {
            System.out.println(book);
        }

        //Listar datos de la bd -- ISABEL ALLENDE
        catalogo =  bookRepository.findByAuthor("ISABEL ALLENDE");

        System.out.println("Listado de libros AUTHOR: ISABEL ALLENDE");
        for (Book book:catalogo) {
            System.out.println(book);
        }
    }
}
