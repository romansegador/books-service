package com.rsegador.workshop.books.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Book {

    String newTitle;
    List<Author> authors;
    String ISBN10;
    String ISBN13;
    String publisher;
    String language;
    boolean eBook;
    int reviewRating;

}
