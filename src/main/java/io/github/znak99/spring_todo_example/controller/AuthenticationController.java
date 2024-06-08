package io.github.znak99.spring_todo_example.controller;

import io.github.znak99.spring_todo_example.domain.User;
import io.github.znak99.spring_todo_example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @GetMapping("/signin")
    public String signin() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "register";
    }

    @PostMapping("/signup")
    public String signup(
            @RequestParam("email") String email,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("password-check") String passwordCheck
    ) {
        System.out.println("log > email: " + email);
        System.out.println("log > username: " + username);
        System.out.println("log > password: " + password);
        System.out.println("log > password-check: " + passwordCheck);

        if (!password.equals(passwordCheck)) {
            return "register";
        }

        User user = new User(username, email, password);
        userService.join(user);
        return "redirect:/signin";
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
