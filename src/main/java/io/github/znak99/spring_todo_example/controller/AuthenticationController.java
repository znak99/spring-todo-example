package io.github.znak99.spring_todo_example.controller;

import io.github.znak99.spring_todo_example.dto.UserDTO;
import io.github.znak99.spring_todo_example.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @GetMapping("/signin")
    public String signin() {
        return "login";
    }

    @GetMapping("/signout")
    public String signout(HttpSession session) {
        session.invalidate();
        return "redirect:/signin";
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
        if (!password.equals(passwordCheck)) {
            return "register";
        }

        UserDTO dto = new UserDTO(username, password, email);
        userService.joinUser(dto);
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
