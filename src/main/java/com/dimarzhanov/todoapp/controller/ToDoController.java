package com.dimarzhanov.todoapp.controller;

import com.dimarzhanov.todoapp.model.TodoItem;
import com.dimarzhanov.todoapp.repositories.TodoItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ToDoController implements CommandLineRunner {

    private final TodoItemRepository todoItemRepository;


    public ToDoController(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
        //this.todoItem = todoItem;
    }

    @GetMapping
    public String index(Model model) {
//        todoItemRepository.save(new TodoItem("Item 1"));  при запуске html страницы каждый раз всплывают тестовые айтемы
//        todoItemRepository.save(new TodoItem("Item 2"));  перенес их вниз в метод ран интерфейса CommandLineRunner
        List<TodoItem> allTodos = todoItemRepository.findAll();
        model.addAttribute("allTodos", allTodos);
        model.addAttribute("newTodo", new TodoItem());

//        for(TodoItem todo : allTodos){
//            System.out.println(todo);
//        }
        //model.addAttribute("data", "Hello");//стартовая страница
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute TodoItem todoItem){
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        todoItemRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/deleteAll")
    public String delete(){
        todoItemRepository.deleteAll();
        return "redirect:/";
    }

    @PostMapping("/search")
    public String searchItem(@RequestParam("searchTerm") String searchTerm, Model model) {
        List<TodoItem> items = todoItemRepository.findAll();

        List<TodoItem> filtered = new ArrayList<>();
        for (TodoItem item : items) {
            if (item.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) && item.getTitle() != null) {
                filtered.add(item);
            }
        }
        model.addAttribute("allTodos", filtered);
        model.addAttribute("newTodo", new TodoItem());
        model.addAttribute("searchTerm", searchTerm); //чтоб было видно искомое слово в поисковой строке
        return "index";
    }

    @Override
    public void run(String... args) throws Exception {
        todoItemRepository.save(new TodoItem("Item 1"));
        todoItemRepository.save(new TodoItem("Item 2"));
    }
}
