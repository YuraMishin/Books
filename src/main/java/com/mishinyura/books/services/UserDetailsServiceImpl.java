package com.mishinyura.books.services;

import com.mishinyura.books.repositories.UsersRepository;
import com.mishinyura.books.security.PersonDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Class UserDetailsServiceImpl.
 * Implements User Details Service.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 01.07.2022
 */
@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    /**
     * Users Repository.
     */
    private final UsersRepository usersRepository;

    /**
     * @param username Username
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        var user = usersRepository.findByUsername(username);
        return user
                .map(PersonDetails::new)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found!")
                );
    }
}
