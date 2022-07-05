package com.mishinyura.books.security;

import com.mishinyura.books.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Class PersonDetails.
 * Implements Person Details.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 01.07.2022
 */
@RequiredArgsConstructor
public class PersonDetails implements UserDetails {
    /**
     * @return User
     */
    public User getUser() {
        return this.user;
    }

    /**
     * User.
     */
    private final User user;

    /**
     * @return Collection<? extends GrantedAuthority>
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections
                .singletonList(new SimpleGrantedAuthority(user.getRole()));
    }

    /**
     * @return String
     */
    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    /**
     * @return String
     */
    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    /**
     * @return boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return boolean
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return boolean
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
