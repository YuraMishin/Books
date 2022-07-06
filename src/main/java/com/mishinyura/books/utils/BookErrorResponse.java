package com.mishinyura.books.utils;

import java.time.LocalDateTime;

/**
 * Class BookErrorResponse.
 * Implements Book Error Response.
 *
 * @param message Message
 * @param date    Date
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 06.07.2022
 */
public record BookErrorResponse(
        String message,
        LocalDateTime date) {
}
