package com.dimarzhanov.todoapp.controller;

import com.dimarzhanov.todoapp.model.TodoItem;
import com.dimarzhanov.todoapp.repositories.TodoItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ToDoController implements CommandLineRunner {

    private final TodoItemRepository todoItemRepository;

    public ToDoController(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping
    public String index(Model model) {
//        todoItemRepository.save(new TodoItem("Item 1"));  при запуске html страницы каждый раз всплывают тестовые айтемы
//        todoItemRepository.save(new TodoItem("Item 2"));  перенес их вниз в метод ран интерфейса CommandLineRunner
        List<TodoItem> allTodos = todoItemRepository.findAll();
        model.addAttribute("allTodos", allTodos);

//        for(TodoItem todo : allTodos){
//            System.out.println(todo);
//        }
        //model.addAttribute("data", "Hello");//стартовая страница
        return "index";
    }

    @Override
    public void run(String... args) throws Exception {
        todoItemRepository.save(new TodoItem("Item 1"));
        todoItemRepository.save(new TodoItem("Item 2"));
    }
}
