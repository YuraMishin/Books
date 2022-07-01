package com.mishinyura.books.repositories;

import com.mishinyura.books.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface UsersRepository.
 * Declares Users Repository.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 01.07.2022
 */
@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    /**
     * Method finds user by username.
     *
     * @param username Username
     * @return Optional<User>
     */
    Optional<User> findByUsername(String username);
}
