package com.dimarzhanov.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("data", "Hello");//стартовая страница
        return "index";
    }
}
