package com.mishinyura.books.controllers;

import com.mishinyura.books.services.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class BookController.
 * Implements Book Controller.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.05.2021
 */
@RequiredArgsConstructor
@Controller
@RequestMapping("/books")
public class BookController {
    /**
     * Book Service.
     */
    private final BookServiceImpl bookService;

    /**
     * Method displays view with all books.
     * GET: /books/
     *
     * @param model Model
     * @return books/index page
     */
    @GetMapping(value = {"", "/"})
    public String index(final Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/index";
    }
}
