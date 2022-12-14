package com.unab.catvirtual.catvirtualg24;

import com.unab.catvirtual.catvirtualg24.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatVirtualG24Application implements CommandLineRunner {
    //Atributo de tipo Repositorio para administra datos de los libros
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookTwoRepository bookTwoRepository;

    @Autowired
    private BookThreeRepository bookThreeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public static void main(String[] args) {
        SpringApplication.run(CatVirtualG24Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        categoryRepository.deleteAll();
        authorRepository.deleteAll();
        bookTwoRepository.deleteAll();
        bookThreeRepository.deleteAll();

        //Crear Categorias

        categoryRepository.saveAll(
                List.of(Category.builder().name("NOVELAS").build(),
                        Category.builder().name("CUENTOS").build(),
                        Category.builder().name("REPORTAJE").build(),
                        Category.builder().name("CIENCIA FICCIÓN").build(),
                        Category.builder().name("NOVELAS AVENTURAS").build(),
                        Category.builder().name("NOVELA NEGRA").build())
        );

        System.out.println("Listado de categorias");
        List<Category> listaCategorias = categoryRepository.findAll();
        for (Category category:listaCategorias) {
            System.out.println(category);
        }


        authorRepository.saveAll(
          List.of(
            Author.builder().id("1").fisrtName("GABRIEL")
                    .lastName("GARCIA MARQUEZ")
                    .country("COLOMBIA")
                    .dateBorn(LocalDate.parse("1927-03-06"))
                    .about("REALISMO MÁGICO")
                    .build(),
                  Author.builder().id("2").fisrtName("MARIO")
                          .lastName("VARGAS LLOSA")
                          .country("PERU")
                          .dateBorn(LocalDate.parse("1937-03-06"))
                          .about("RENUNCIO AL SOCIALISMO Y AHORA ES OTRO CUENTO")
                          .build(),
                  Author.builder().id("3").fisrtName("ISABEL")
                          .lastName("ALLENDE")
                          .country("CHILE")
                          .dateBorn(LocalDate.parse("1945-03-06"))
                          .about("AUTORA SIEMPRE JOVEN")
                          .build()
            )
        );

        System.out.println("Listado de autores");
        List<Author> listadoAutores = authorRepository.findAll();
        for (Author author:listadoAutores) {
            System.out.println(author);
        }



        Category category = categoryRepository.findById("1").get();
        Author authorOne = authorRepository.findById("1").get();
        Author authorTwo = authorRepository.findById("2").get();
        Author authorThree = authorRepository.findById("3").get();

        //Ejemplo con documentos embebidos
        bookTwoRepository.saveAll(
                List.of(BookTwo.builder().isbn("123")
                        .title("EL GENERAL EN SU LABERINTO")
                        .description("ULTIMOS DIAS DE BOLIVAR")
                        .pages(300)
                        .price(45000)
                        .year(1990)
                        .seleccionado(true)
                        .category(category)
                        .author(authorOne)
                        .build(),
                        BookTwo.builder().isbn("124")
                                .title("LA CIUDAD Y LOS PERROS")
                                .description("LA OBRA ESTÁ AMBIENTADA EN EL COLEGIO MILITAR LEONCIO PRADO, DONDE ADOLESCENTES Y JÓVENES INTERNOS RECIBEN FORMACIÓN ESCOLAR SECUNDARIA BAJO UNA SEVERA DISCIPLINA MILITAR. SE NARRAN LAS DIFERENTES HISTORIAS DE UNOS MUCHACHOS QUE DESCUBREN Y APRENDEN A CONVIVIR CON UNA FORMA DE VIDA ALIENANTE QUE NO LES PERMITE DESARROLLARSE COMO PERSONAS, Y DONDE SE LES SOMETE Y HUMILLA. NO OBSTANTE, A TRAVÉS DE ESTE SISTEMA, ALGUNOS ENCUENTRAN LA FORTALEZA NECESARIA PARA ASUMIR SUS RETOS.")
                                .pages(280)
                                .price(45000)
                                .year(1990)
                                .seleccionado(true)
                                .category(category)
                                .author(authorTwo)
                                .build(),
                        BookTwo.builder().isbn("125")
                                .title("LA SUMA DE LOS DÍAS")
                                .description("ISABEL ALLENDE NARRA A SU HIJA PAULA TODO LO QUE HA SUCEDIDO CON LA FAMILIA DESDE EL MOMENTO EN QUE ELLA MURIÓ. EL LECTOR VIVE, JUNTO CON LA AUTORA, LA SUPERACIÓN PERSONAL DE UNA MUJER CON UNA FUERZA INSPIRADORA, RODEADA SIEMPRE DE AMIGOS Y FAMILIARES. SU HISTORIA ES EMOTIVA, PERO TAMBIÉN ESTÁ REPLETA DE HUMOR, PERSONAJES PINTORESCOS Y ANÉCDOTAS CAÓTICAS Y DIVERTIDAS SOBRE LA COMPLICIDAD, EL AMOR, LA ESPERANZA, LA MAGIA Y LA FUERZA DE LA AMISTAD.UNA LECCIÓN MAGISTRAL DE CÓMO HACER FRENTE A LOS DISTINTOS RETOS QUE DEPARA LA VIDA.")
                                .pages(280)
                                .price(45000)
                                .year(1990)
                                .seleccionado(true)
                                .category(category)
                                .author(authorThree)
                                .build()
                )
        );

        Category category = categoryRepository.findById("639918f5cba0f63960302343").get();
        Author authorOne = authorRepository.findById("63991939cba0f63960302345").get();

        //Ejemplo con relaciones mediante referencias
        bookThreeRepository.saveAll(
                List.of(BookThree.builder().isbn("123")
                                .title("EL GENERAL EN SU LABERINTO")
                                .description("ULTIMOS DIAS DE BOLIVAR")
                                .pages(300)
                                .price(45000)
                                .year(1990)
                                .seleccionado(true)
                                .category(category)
                                .author(authorOne)
                                .build(),
                        BookThree.builder().isbn("124")
                                .title("CIEN AÑOS DE SOLEDAD")
                                .description("ENTRE LA BODA DE JOSÉ ARCADIO BUENDÍA CON AMELIA IGUARÁN HASTA LA MALDICIÓN DE AURELIANO BABILONIA TRANSCURRE TODO UN SIGLO. CIEN AÑOS DE SOLEDAD PARA UNA ESTIRPE ÚNICA, FANTÁSTICA, CAPAZ DE FUNDAR UNA CIUDAD TAN ESPECIAL COMO MACONDO Y DE ENGENDRAR NIÑOS CON COLA DE CERDO. EN MEDIO, UNA LARGA DOCENA DE PERSONAJES DEJARÁN SU IMPRONTA A LAS GENERACIONES VENIDERAS, QUE TENDRÁN QUE LIDIAR CON UN MUNDO TAN COMPLEJO COMO SENCILLO.")
                                .pages(280)
                                .price(45000)
                                .year(1990)
                                .seleccionado(true)
                                .category(category)
                                .author(authorOne)
                                .build(),
                        BookThree.builder().isbn("125")
                                .title("CRÓNICA DE UNA MUERTE ANUNCIADA")
                                .description("CRÓNICA DE UNA MUERTE ANUNCIADA ES UNA NOVELA CORTA DE GABRIEL GARCÍA MÁRQUEZ, PUBLICADA EN 1981. TOMANDO ELEMENTOS DEL REALISMO MÁGICO Y DEL RELATO POLICIAL, LA NOVELA CUENTA LA MUERTE DE SANTIAGO NASAR A MANOS DE LOS HERMANOS VICARIO.")
                                .pages(280)
                                .price(45000)
                                .year(1990)
                                .seleccionado(true)
                                .category(category)
                                .author(authorOne)
                                .build()
                )
        );
*/
        /*
        System.out.println("Listado de Libros - v1");
        List<Book> listadoLibros = bookRepository.findAll();
        for (Book book:listadoLibros) {
            System.out.println(book);
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Listado de Libros - v2");
        List<BookTwo> listadoLibrosV2 = bookTwoRepository.findAll();
        for (BookTwo bookTwo:listadoLibrosV2) {
            System.out.println(bookTwo);
        }


        System.out.println("---------------------------------------------------------------------");
        System.out.println("Listado de Libros - v3");
        List<BookThree> listadoLibrosV3 = bookThreeRepository.findAll();
        for (BookThree bookThree:listadoLibrosV3) {
            System.out.println(bookThree);
        }

         */
    }
}

