package com.mishinyura.books.exception;

/**
 * Class DaoException.
 * Implements DAO Exception.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.05.2022
 */
public class DaoException extends RuntimeException {
    /**
     * Constructor.
     *
     * @param throwable Throwable
     */
    public DaoException(final Throwable throwable) {
        super(throwable);
    }
}
