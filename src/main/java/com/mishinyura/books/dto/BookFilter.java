package com.mishinyura.books.dto;

/**
 * Class BookFilter.
 * Implements book filter.
 *
 * @param limit  Limit
 * @param offset Offset
 * @param title  Title
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 19.05.2022
 */

public record BookFilter(int limit, int offset, String title) {
}
