package com.unab.catvirtual.catvirtualg24.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
@Builder
public class Book {
    @Id
    private String isbn;
    private String category;
    private String title;
    private String author;
    private int pages;
    private long price;
    private int year;
    private boolean seleccionado;
    private String description;
}
