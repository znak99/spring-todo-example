package io.github.znak99.spring_todo_example.controller;

import io.github.znak99.spring_todo_example.domain.User;
import io.github.znak99.spring_todo_example.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class TodoController {

    private final UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            Optional<User> userOptional = userService.findUserByEmail(username);
            User user = userOptional.get();
            model.addAttribute("user", user);

            return "index";
        } else {
            return "redirect:/signin";
        }
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @GetMapping("/edit")
    public String edit() {
        return "edit";
    }

    @GetMapping("/delete-confirm")
    public String deleteConfirm() {
        return "delete-confirm";
    }
}
