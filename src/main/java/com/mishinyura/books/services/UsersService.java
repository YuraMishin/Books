package com.mishinyura.books.services;

import com.mishinyura.books.models.User;

import java.util.Optional;

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

    /**
     * Method finds user by username.
     *
     * @param username Username
     * @return Optional<User>
     */
    Optional<User> findByUsername(String username);
}
