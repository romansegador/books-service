package com.rsegador.workshop.books.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Author {
    String firstName;
    String lastName;
}
