package com.rsegador.workshop.books;

import com.google.common.collect.ImmutableList;
import com.rsegador.workshop.books.dto.Author;
import com.rsegador.workshop.books.dto.Book;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.rsegador.workshop.books.BookRepository.Fixture.agileTesting;
import static com.rsegador.workshop.books.BookRepository.Fixture.devOps;
import static com.rsegador.workshop.books.BookRepository.Fixture.exploreIt;
import static com.rsegador.workshop.books.BookRepository.Fixture.moreAgileTesting;
import static com.rsegador.workshop.books.BookRepository.Fixture.tdd;

@Component
public class BookRepository {

    public List<Book> getAllBooks() {
        return ImmutableList.of(agileTesting, moreAgileTesting, exploreIt, tdd, devOps);
    }

    interface Fixture {
        Author lisa = Author.builder()
                .firstName("Lisa")
                .lastName("Crispin").build();

        Author janet = Author.builder()
                .firstName("Janet")
                .lastName("Gregory").build();

        Author elisabeth = Author.builder()
                .firstName("Elisabeth")
                .lastName("Hendrickson").build();

        Author carlos = Author.builder()
                .firstName("Carlos")
                .lastName("Ble").build();

        Author katrina = Author.builder()
                .firstName("Katrina")
                .lastName("Clokie").build();

        Book agileTesting = Book.builder()
                .title("Agile Testing: A Practical Guide for Testers and Agile Teams")
                .authors(ImmutableList.of(lisa, janet))
                .ISBN10("9780321534460")
                .ISBN13("978-0321534460")
                .publisher("Addison-Wesley Professional")
                .language("English")
                .eBook(false)
                .reviewRating(5)
                .build();

        Book moreAgileTesting = Book.builder()
                .title("More Agile Testing: Learning Journeys for the Whole Team")
                .authors(ImmutableList.of(janet, lisa))
                .ISBN10("0321967054")
                .ISBN13("978-0321967053")
                .publisher("Addison-Wesley Professional")
                .language("English")
                .reviewRating(5)
                .eBook(false)
                .build();

        Book exploreIt = Book.builder()
                .title("Explore It!: Reduce Risk and Increase Confidence with Exploratory Testing")
                .authors(ImmutableList.of(elisabeth))
                .ISBN10("1937785025")
                .ISBN13("978-1937785024")
                .publisher("Pragmatic Bookshelf")
                .language("English")
                .reviewRating(4)
                .eBook(false)
                .build();

        Book tdd = Book.builder()
                .title("Diseño Ágil con TDD")
                .authors(ImmutableList.of(carlos))
                .publisher("Leanpub")
                .language("Spanish")
                .reviewRating(4)
                .eBook(true)
                .build();

        Book devOps = Book.builder()
                .title("A Practical Guide to Testing in DevOps")
                .authors(ImmutableList.of(katrina))
                .publisher("Leanpub")
                .language("English")
                .reviewRating(5)
                .eBook(true)
                .build();
    }
}
