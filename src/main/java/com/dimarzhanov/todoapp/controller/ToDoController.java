package com.dimarzhanov.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {

    @GetMapping
    public String index() { //стартовая страница
        return "index";
    }
}
