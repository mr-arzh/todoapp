package com.dimarzhanov.todoapp.repositories;

import com.dimarzhanov.todoapp.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {






}
