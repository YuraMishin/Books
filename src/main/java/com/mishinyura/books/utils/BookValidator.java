package com.mishinyura.books.utils;

import com.mishinyura.books.models.BookV2;
import com.mishinyura.books.repositories.BooksRepository;
import com.mishinyura.books.services.BooksServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Class BookValidator.
 * Implements Book Validator.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 15.06.2022
 */
@RequiredArgsConstructor
@Component
public class BookValidator implements Validator {
    /**
     * Book Service.
     */
    private final BooksServiceImpl booksService;

    private final BooksRepository booksRepository;

    @Override
    public boolean supports(final Class<?> clazz) {
        return BookV2.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        BookV2 book = (BookV2) target;
        if (booksRepository.findByTitle(book.getTitle()).isPresent()) {
            errors.rejectValue("title", "", "This title is already taken");
        }
    }
}
