package com.mishinyura.books.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class AuthController.
 * Implements Auth Controller.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 04.07.2022
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
    /**
     * Method displays custom login view.
     * GET: /auth/login
     *
     * @return auth/login custom login view
     */
    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }
}
