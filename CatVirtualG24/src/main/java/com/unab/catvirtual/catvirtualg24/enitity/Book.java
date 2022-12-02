package com.unab.catvirtual.catvirtualg24.enitity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
public class Book {
    @Id
    private String isbn;
    private String title;
    private String author;
    private int pages;
    private long price;
    private String description;
}
