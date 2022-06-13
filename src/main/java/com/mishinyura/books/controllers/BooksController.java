package com.mishinyura.books.controllers;

import com.mishinyura.books.models.BookV2;
import com.mishinyura.books.services.BooksServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
     * @return books/index page view
     */
    @GetMapping(value = {"", "/"})
    public String index(final Model model) {
//        model.addAttribute("books", booksService.findAll());
        model.addAttribute("books", booksService.findAllViaJDBCTemplate());
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
    public String show(@PathVariable final Long id, final Model model) {
//        model.addAttribute("book", booksService.findById(id));
        model.addAttribute("book", booksService.findByIdViaJDBCTemplate(id));
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
    public String create(@ModelAttribute("book") final BookV2 book) {
        return "books/new";
    }

    /**
     * Method saves the book.
     * POST: /books/
     *
     * @param book          Book
     * @param bindingResult BindingResult
     * @return books/index page view
     */
    @PostMapping(value = "/")
    public String store(@Valid @ModelAttribute("book") final BookV2 book,
                        final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/new";
        }
        booksService.save(book);
        return "redirect:/books/";
    }

    /**
     * Method displays view to update the book.
     * GET: /books/{id}/edit
     *
     * @param id    Id
     * @param model Model
     * @return books/edit book view
     */
    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable final Long id, final Model model) {
        model.addAttribute("book", booksService.findById(id));
        return "books/edit";
    }

    /**
     * Method updates the book.
     * PATCH: /books/{id}
     *
     * @param book          Book
     * @param bindingResult BindingResult
     * @param id            Id
     * @return books/index page view
     */
    @PatchMapping(value = "/{id}")
    public String update(@Valid @ModelAttribute("book") final BookV2 book,
                         final BindingResult bindingResult,
                         @PathVariable("id") final Long id) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }
        BookV2 bookToBeUpdated = booksService.findById(id);
        bookToBeUpdated.setTitle(book.getTitle());
        booksService.save(bookToBeUpdated);
        return "redirect:/books/";
    }

    /**
     * Method removes the book by id.
     * DELETE: /books/{id}
     *
     * @param id Id
     * @return books/index page view
     */
    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id") final Long id) {
        booksService.deleteById(id);
        return "redirect:/books/";
    }

    /**
     * Method adds ten books.
     * GET: /books/addTen
     *
     * @return books/index page view
     */
    @GetMapping(value = "/addTen")
    public String addTenBooks() {
        booksService.addTenBooks();
        return "redirect:/books/";
    }
}
