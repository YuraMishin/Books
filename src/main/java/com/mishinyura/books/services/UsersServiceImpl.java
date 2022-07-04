package com.mishinyura.books.services;

import com.mishinyura.books.models.User;
import com.mishinyura.books.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class UsersServiceImpl.
 * Implements Users Service.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 04.07.2022
 */
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UsersServiceImpl implements UsersService {
    /**
     * Users Repository.
     */
    private final UsersRepository usersRepository;

    /**
     * Method saves the user.
     *
     * @param user User
     */
    @Override
    @Transactional
    public void save(final User user) {
        usersRepository.save(user);
    }
}
