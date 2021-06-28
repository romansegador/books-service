package com.rsegador.workshop.books;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import au.com.dius.pact.provider.spring.junit5.PactVerificationSpringProvider;
import com.google.common.collect.ImmutableList;
import com.rsegador.workshop.books.dto.Author;
import com.rsegador.workshop.books.dto.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.rsegador.workshop.books.ContractTest.TestData.book;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@Provider("books-service")
@PactBroker
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
public class ContractTest {

    @LocalServerPort
    private int serverPort;

    @MockBean
    BookService bookService;


    @TestTemplate
    @ExtendWith(PactVerificationSpringProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        if(context != null) {
            context.verifyInteraction();
        }
    }

    @BeforeEach
    void setTarget(PactVerificationContext context) {
        if(context != null) {
            context.setTarget(new HttpTestTarget("localhost", serverPort));
        }
    }

    @State("books available")
    public void booksAvailable() {
        when(bookService.getAllBooks())
                .thenReturn(ImmutableList.of(book));
    }

    @State("no books available for an author")
    public void noBooksAvailableForAuthor() {
        when(bookService.getBooks(any(), any()))
                .thenReturn(ImmutableList.of());
    }

    @State("books available for an author")
    public void booksAvailableForAuthor() {
        when(bookService.getBooks(any(), any()))
                .thenReturn(ImmutableList.of(book));
    }

    interface TestData {
        Author author = Author.builder().firstName("FName").lastName("LName").build();
        Book book = Book.builder()
                .newTitle("the title of the book")
                .authors(ImmutableList.of(author))
                .ISBN10("5550000000000")
                .ISBN13("555-00000000000")
                .publisher("The Publisher")
                .language("Klingon")
                .eBook(false)
                .reviewRating(5)
                .build();
    }

}
