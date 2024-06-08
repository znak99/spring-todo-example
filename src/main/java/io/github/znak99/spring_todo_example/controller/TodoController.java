package io.github.znak99.spring_todo_example.controller;

import io.github.znak99.spring_todo_example.domain.User;
import io.github.znak99.spring_todo_example.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class TodoController {

    private final UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
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
