package com.mishinyura.books.config;

import com.mishinyura.books.security.AuthProviderImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Class SecurityConfig.
 * Implements Security Configuration for Spring App.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.06.2022
 */
@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Auth Provider.
     */
    private final AuthProviderImpl authProvider;

    /**
     * @param auth AuthenticationManagerBuilder
     */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider);
    }
}
