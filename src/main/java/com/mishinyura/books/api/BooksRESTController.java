package com.mishinyura.books.api;

import com.mishinyura.books.exceptions.BookNotFoundException;
import com.mishinyura.books.models.BookV2;
import com.mishinyura.books.services.BooksServiceImpl;
import com.mishinyura.books.utils.BookErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class BooksRESTController.
 * Implements Books REST Controller.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 06.07.2022
 */
@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@Slf4j
public class BooksRESTController {
    /**
     * Books Service.
     */
    private final BooksServiceImpl booksService;

    /**
     * Method retrieves all the books.
     * GET: api/books/
     *
     * @return List<BookV2>
     */
    @GetMapping("/")
    public List<BookV2> getBooks() {
        return booksService.findAll();
    }

    /**
     * Method retrieves the specific book.
     * GET: api/books/1
     *
     * @param id Id
     * @return BookV2
     */
    @GetMapping("/{id}")
    public BookV2 getBook(@PathVariable final Long id) {
        return booksService.findById(id);
    }

    /**
     * Method handles BookNotFoundException.
     *
     * @param e Exception
     * @return ResponseEntity<BookErrorResponse>
     */
    @ExceptionHandler
    private ResponseEntity<BookErrorResponse> handleBookNotFoundException(final BookNotFoundException e) {
        var response = new BookErrorResponse(
                "Book not found !",
                LocalDateTime.now()
        );
        log.error("{} - Exception caught - {}", response.date(), response.message());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Method saves the book.
     * POST: api/books/
     *
     * @param book Book
     * @return ResponseEntity<HttpStatus>
     */
    @PostMapping
    public ResponseEntity<HttpStatus> store(@RequestBody final BookV2 book) {
        booksService.save(book);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
