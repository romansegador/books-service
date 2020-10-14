package com.rsegador.workshop.books;

import com.rsegador.workshop.books.dto.Book;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    BookService bookService;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {}

    @GetMapping("/api/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/api/books/byauthor")
    public List<Book> getBooks(@RequestParam String firstName, @RequestParam String lastName) {
        List<Book> books = bookService.getBooks(firstName, lastName);
        if (isEmpty(books)) {
            throw new ResourceNotFoundException();
        } else {
            return books;
        }
    }
}
