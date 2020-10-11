package com.rsegador.workshop.books;

import com.rsegador.workshop.books.dto.Book;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    BookService bookService;

    @GetMapping("/api/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/api/books/byauthor")
    public List<Book> getBooks(@RequestParam String firstName, @RequestParam String lastName) {
        return bookService.getBooks(firstName, lastName);
    }
}
