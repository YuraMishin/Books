package com.mishinyura.books.api;

import com.mishinyura.books.models.BookV2;
import com.mishinyura.books.services.BooksServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BooksRESTController {
    /**
     * Books Service.
     */
    private final BooksServiceImpl booksService;

    /**
     * Method retrieves all the books.
     * GET: /books
     *
     * @return List<BookV2>
     */
    @GetMapping("/books")
    public List<BookV2> getBooks() {
        return booksService.findAll();
    }
}
