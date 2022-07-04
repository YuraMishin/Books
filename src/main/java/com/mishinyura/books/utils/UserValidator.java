package com.mishinyura.books.utils;

import com.mishinyura.books.models.User;
import com.mishinyura.books.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Class UserValidator.
 * Implements User Validator.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 04.07.2022
 */
@RequiredArgsConstructor
@Component
public class UserValidator implements Validator {
    /**
     * Users Service.
     */
    private final UsersService usersService;

    /**
     * @param clazz Clazz
     * @return boolean
     */
    @Override
    public boolean supports(final Class<?> clazz) {
        return User.class.equals(clazz);
    }

    /**
     * @param target Target
     * @param errors Errors
     */
    @Override
    public void validate(final Object target, final Errors errors) {
        var user = (User) target;
        if (usersService.findByUsername(user.getUsername()).isPresent()) {
            errors.rejectValue("username", "",
                    "This username is already taken");
        }
    }
}
