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
        /*
        bookRepository.deleteAll();

        //Crear Libros
        //Book oneBook = new Book();

        Book oneBook = Book.builder().build();
        //Asignar atributos
        oneBook.setIsbn("123");
        oneBook.setCategory("NOVELAS");
        oneBook.setTitle("EL CORONEL NO TIENE QUIEN LE ESCRIBA");
        oneBook.setAuthor("GABRIEL GARCIA MARQUEZ");
        oneBook.setPages(300);
        oneBook.setPrice(50000);
        oneBook.setSeleccionado(false);
        oneBook.setYear(1961);
        oneBook.setDescription("HISTORIA DEL GRAL AURELIANO BUENDIA");

        //Insertar en la base de datos
        bookRepository.insert(oneBook);

        //insercion de varios objetos Libro mediante una lista y uso de patron Builder que nos provee la libreria Lombok
        bookRepository.saveAll(
                List.of(Book.builder().isbn("124")
                        .category("NOVELAS")
                        .title("CIEN AÑOS DE SOLEDAD")
                        .author("GABRIEL GARCIA MARQUEZ")
                        .pages(250)
                        .price(55000)
                        .year(1967)
                        .seleccionado(false)
                        .description("ENTRE LA BODA DE JOSÉ ARCADIO BUENDÍA CON AMELIA IGUARÁN HASTA LA MALDICIÓN DE AURELIANO BABILONIA TRANSCURRE TODO UN SIGLO. CIEN AÑOS DE SOLEDAD PARA UNA ESTIRPE ÚNICA, FANTÁSTICA, CAPAZ DE FUNDAR UNA CIUDAD TAN ESPECIAL COMO MACONDO Y DE ENGENDRAR NIÑOS CON COLA DE CERDO. EN MEDIO, UNA LARGA DOCENA DE PERSONAJES DEJARÁN SU IMPRONTA A LAS GENERACIONES VENIDERAS, QUE TENDRÁN QUE LIDIAR CON UN MUNDO TAN COMPLEJO COMO SENCILLO.")
                        .build(),
                        Book.builder().isbn("125")
                                .category("NOVELAS")
                                .title("CRÓNICA DE UNA MUERTE ANUNCIADA")
                                .author("GABRIEL GARCIA MARQUEZ")
                                .pages(250)
                                .price(45000)
                                .year(1981)
                                .seleccionado(false)
                                .description("CRÓNICA DE UNA MUERTE ANUNCIADA ES UNA NOVELA CORTA DE GABRIEL GARCÍA MÁRQUEZ, PUBLICADA EN 1981. TOMANDO ELEMENTOS DEL REALISMO MÁGICO Y DEL RELATO POLICIAL, LA NOVELA CUENTA LA MUERTE DE SANTIAGO NASAR A MANOS DE LOS HERMANOS VICARIO.")
                                .build(),
                        Book.builder().isbn("126")
                                .category("NOVELAS")
                                .title("LA CASA VERDE")
                                .author("MARIO VARGAS LLOSA")
                                .pages(534)
                                .price(45000)
                                .year(1967)
                                .seleccionado(false)
                                .description("EN ESTA NOVELA CONFLUYEN MUCHAS HISTORIAS QUE, ESPACIAL Y TEMPORALMENTE, SE ENTRECRUZAN, SE COMPLEMENTAN Y SE ENRIQUECEN MUTUAMENTE, SIN EMBARGO, ES POSIBLE DISTINGUIR TRES HISTORIAS “BASE”: LA DE DON ANSELMO, LA DEL SARGENTO LITUMA Y LA DEL BANDIDO FUSHÍA.")
                                .build(),
                        Book.builder().isbn("127")
                                .category("NOVELAS")
                                .title("LA CIUDAD Y LOS PERROS")
                                .author("MARIO VARGAS LLOSA")
                                .build()
                        ));


        //Consultar datos del libro
        List<Book> catalogo =  bookRepository.findAll();

        System.out.println("Catalogo de Libros");
        for (Book book:catalogo) {
            System.out.println(book.toString());
        }

        //Actualizar un libro
        //Obtener el libro a partir de su id
        Optional<Book> opcional = bookRepository.findById("127");
        //valido si el libro existe
        if (!opcional.isEmpty()){
            oneBook = opcional.get();
            System.out.println("Libro con el id: 127");
            System.out.println(oneBook);

            //Actualiza información faltante del objeto
            oneBook.setYear(1963);
            oneBook.setPrice(45000);
            oneBook.setPages(472);
            oneBook.setSeleccionado(false);
            oneBook.setDescription("LA OBRA ESTÁ AMBIENTADA EN EL COLEGIO MILITAR LEONCIO PRADO, DONDE ADOLESCENTES Y JÓVENES INTERNOS RECIBEN FORMACIÓN ESCOLAR SECUNDARIA BAJO UNA SEVERA DISCIPLINA MILITAR. SE NARRAN LAS DIFERENTES HISTORIAS DE UNOS MUCHACHOS QUE DESCUBREN Y APRENDEN A CONVIVIR CON UNA FORMA DE VIDA ALIENANTE QUE NO LES PERMITE DESARROLLARSE COMO PERSONAS, Y DONDE SE LES SOMETE Y HUMILLA. NO OBSTANTE, A TRAVÉS DE ESTE SISTEMA, ALGUNOS ENCUENTRAN LA FORTALEZA NECESARIA PARA ASUMIR SUS RETOS.");

            //actualiza el objeto en la base de datos
            bookRepository.save(oneBook);

            //Consultar datos del libro
            catalogo =  bookRepository.findAll();

            System.out.println("Catalogo de Libros");
            for (Book book:catalogo) {
                System.out.println(book.toString());
            }
        }else{
            System.out.println("Libro con el id: 128 no existe");
        }

        //borrado de datos
        opcional = bookRepository.findById("127");
        if (!opcional.isEmpty()) {
            oneBook = opcional.get();
            System.out.println("Libro con el id: 127");
            System.out.println(oneBook);

            //borrado
            bookRepository.delete(oneBook);
            //Consultar datos del libro
            catalogo =  bookRepository.findAll();

            System.out.println("Catalogo de Libros");
            for (Book book:catalogo) {
                System.out.println(book.toString());
            }

        }
         */
        //Consultar datos del libro c categoria
        /*
        List<Book> catalogo =  bookRepository.findByCategory("NOVELAS");
        System.out.println("Catalogo de Libros que corresponden con la categoria 'NOVELAS'");
        for (Book book:catalogo) {
            System.out.println(book.toString());
        }

        catalogo =  bookRepository.findByAuthor("GABRIEL GARCIA MARQUEZ");
        System.out.println("Catalogo de Libros de GABRIEL GARCIA MARQUEZ'");
        for (Book book:catalogo) {
            System.out.println(book.toString());
        }
        */
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

