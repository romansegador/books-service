package com.rsegador.workshop.books;

import com.rsegador.workshop.books.dto.Author;
import com.rsegador.workshop.books.dto.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BookService {

    BookRepository bookRepository;

    List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    List<Book> getBooks(String firstname, String lastname) {
        List<Book> allBooks = bookRepository.getAllBooks();
        Author author = Author.builder().firstName(firstname).lastName(lastname).build();
        return allBooks.stream().filter(book -> book.getAuthors().contains(author)).collect(Collectors.toList());
    }

}
