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
        //Borrar Libros
        bookRepository.deleteAll();

        //Crear Libros
        Book oneBook = new Book();

        //Asignar atributos
        oneBook.setIsbn("123");
        oneBook.setTitle("EL CORONEL NO TIENE QUIEN LE ESCRIBA");
        oneBook.setAuthor("GABRIEL GARCIA MARQUEZ");
        oneBook.setPages(300);
        oneBook.setPrice(50000);
        oneBook.setDescription("HISTORIA DEL GRAL AURELIANO BUENDIA");

        //Insertar en la base de datos
        bookRepository.insert(oneBook);

        oneBook = new Book();
        oneBook.setIsbn("124");
        oneBook.setTitle("EL GENERAL EN SU LABERINTO");
        oneBook.setAuthor("GABRIEL GARCIA MARQUEZ");
        oneBook.setPages(300);
        oneBook.setPrice(30000);
        oneBook.setDescription("HISTORIA DEL BOLIVAR EN SUS ULTIMOS DIAS");

        //Insertar en la base de datos
        bookRepository.insert(oneBook);

        oneBook = new Book();
        oneBook.setIsbn("125");
        oneBook.setTitle("MEMORIAS DE MIS PUTAS TRISTES");
        oneBook.setAuthor("GABRIEL GARCIA MARQUEZ");
        oneBook.setPages(250);
        oneBook.setPrice(20000);
        oneBook.setDescription("HISTORIA DE UN VIEJO EN SUS ULTIMOS  DIAS DE VIDA");

        //Insertar en la base de datos
        bookRepository.insert(oneBook);

        oneBook = new Book();
        oneBook.setIsbn("126");
        oneBook.setTitle("PANTALEON Y LAS VISITADORAS");
        oneBook.setAuthor("MARIO VARGAS LLOSA");
        oneBook.setPages(300);
        oneBook.setPrice(50000);
        oneBook.setDescription("HISTORIA DEL BURDEL PERUANO");

        //Insertar en la base de datos
        bookRepository.insert(oneBook);

        oneBook = new Book();
        oneBook.setIsbn("127");
        oneBook.setTitle("EL SUEÑO DEL CELTA");
        oneBook.setAuthor("MARIO VARGAS LLOSA");
        oneBook.setPages(300);
        oneBook.setPrice(50000);
        oneBook.setDescription("HISTORIA DE UN DIPLOMATICO BRITANICO CON PROBLEMAS POR SU ORIENTACION SEXUAL");

        //Insertar en la base de datos
        bookRepository.insert(oneBook);

        oneBook = new Book();
        oneBook.setIsbn("128");
        oneBook.setTitle("EL SARI ROJO");
        oneBook.setAuthor("JAVIER MORO");
        oneBook.setPages(300);
        oneBook.setPrice(50000);
        oneBook.setDescription("SOBRE INDIRA GANDHI Y SU FAMILIA");

        //Insertar en la base de datos
        bookRepository.insert(oneBook);

        oneBook = new Book();
        oneBook.setIsbn("129");
        oneBook.setTitle("EL I9MPERIO ESRES TU");
        oneBook.setAuthor("JAVIER MORO");
        oneBook.setPages(300);
        oneBook.setPrice(50000);
        oneBook.setDescription("HISTORIA DEL IMPERIO PORTUGUEZ EN BRASIL");

        //Insertar en la base de datos
        bookRepository.insert(oneBook);

        //Consultar datos del libro
        List<Book> catalogo =  bookRepository.findAll();

        System.out.println("Catalogo de Libros");
        for (Book book:catalogo) {
            System.out.println(book.toString());
        }

        //Actualizar un libro
        //Obtener el libro a partir de su id
        Optional<Book> opcional = bookRepository.findById("125");

        //valido si el libro existe
        if (!opcional.isEmpty()){
            oneBook = opcional.get();
            System.out.println("Libro con el id: 63894c3cbaab4d5ed0457eea");
            System.out.println(oneBook);
        }





    }
}
