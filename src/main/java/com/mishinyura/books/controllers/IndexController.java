package com.mishinyura.books.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class IndexController.
 * Implements Index Controller.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.05.2022
 */
@Controller
public class IndexController {
    /**
     * Method displays helloworld string.
     * GET: /hello
     *
     * @return String
     */
    @GetMapping(value = {"/hello"})
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

    /**
     * Method displays index page.
     * GET: /, /index
     *
     * @return index index page view
     */
    @GetMapping(value = {"", "/", "/index"})
    public String index() {
        return "index";
    }

    /**
     * Method displays admin page.
     * GET: /admin
     *
     * @return admin admin page view
     */
    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}
