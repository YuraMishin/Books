package com.mishinyura.books.controllers;

import com.mishinyura.books.models.BookV2;
import com.mishinyura.books.services.BooksServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class BooksController.
 * Implements Books Controller.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.05.2021
 */
@RequiredArgsConstructor
@Controller
@RequestMapping("/books")
public class BooksController {
    /**
     * Book Service.
     */
    private final BooksServiceImpl booksService;

    /**
     * Method displays view with all books.
     * GET: /books/
     *
     * @param model Model
     * @return books/index page
     */
    @GetMapping(value = {"", "/"})
    public String index(final Model model) {
        model.addAttribute("books", booksService.findAll());
        return "books/index";
    }

    /**
     * Method displays view with the specific book.
     * GET: /books/{id}
     *
     * @param id    Id
     * @param model Model
     * @return books/show specific book page view
     */
    @GetMapping(value = "/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("book", booksService.findById(Long.parseLong(id)));
        return "books/show";
    }

    /**
     * Method displays view to create a book.
     * GET: /books/new
     *
     * @param book Book
     * @return books/new book view
     */
    @GetMapping(value = "/new")
    public String create(@ModelAttribute("book") BookV2 book) {
        return "books/new";
    }

    /**
     * Method saves the book.
     * POST: /books/
     *
     * @param book Book
     * @return books/index page
     */
    @PostMapping(value = "/")
    public String store(@ModelAttribute("book") BookV2 book) {
        booksService.save(book);
        return "redirect:/books/";
    }
}
