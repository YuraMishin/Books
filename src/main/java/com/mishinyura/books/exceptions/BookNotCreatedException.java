package com.mishinyura.books.exceptions;

/**
 * Class BookNotCreatedException.
 * Implements BookNotCreatedException.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 06.07.2022
 */
public class BookNotCreatedException extends RuntimeException {

    /**
     * Constructor.
     *
     * @param message Message
     */
    public BookNotCreatedException(final String message) {
        super(message);
    }
}
