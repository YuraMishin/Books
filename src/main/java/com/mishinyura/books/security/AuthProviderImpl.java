package com.mishinyura.books.security;

import com.mishinyura.books.services.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Class AuthProviderImpl.
 * Implements AuthProvider.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 01.07.2022
 */
@AllArgsConstructor
@Component
public class AuthProviderImpl implements AuthenticationProvider {
    /**
     * User Details Service.
     */
    private final UserDetailsServiceImpl userDetailsService;

    /**
     * @param authentication Authentication
     * @return Authentication
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        var username = authentication.getName();
        var password = authentication.getCredentials().toString();

        var userDetails = userDetailsService.loadUserByUsername(username);
        if (!password.equals(userDetails.getPassword())) {
            throw new BadCredentialsException("Wrong credentials!");
        }
        return new UsernamePasswordAuthenticationToken(
                userDetails,
                password,
                Collections.emptyList()
        );
    }

    /**
     * @param authentication Authentication
     * @return boolean
     */
    @Override
    public boolean supports(final Class<?> authentication) {
        return true;
    }
}
