package com.mishinyura.books.api;

import com.mishinyura.books.models.BookV2;
import com.mishinyura.books.services.BooksServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
