package io.github.znak99.spring_todo_example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/signin")
    public String signin() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "register";
    }

    @GetMapping("/email-authenticate")
    public String emailAuthenticate() {
        return "email-authenticate";
    }

    @GetMapping("/password-reset")
    public String passwordReset() {
        return "password-reset";
    }

}
