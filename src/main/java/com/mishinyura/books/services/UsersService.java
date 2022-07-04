package com.mishinyura.books.services;

import com.mishinyura.books.models.User;

/**
 * Interface UsersService.
 * Declares Users Service.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 04.07.2022
 */
public interface UsersService {
    /**
     * Method saves the user.
     *
     * @param user User
     */
    void save(User user);
}
