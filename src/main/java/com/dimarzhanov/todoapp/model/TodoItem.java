package com.dimarzhanov.todoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TodoItem {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    public TodoItem() {
    }

    public TodoItem(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    @Override
//    public String toString() {
//        return "TodoItem{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                '}';
//    }

//    public String findAny(String word){
//        if(title.contains(word)){
//            return word;
//        } else {
//            return "missing object";
//        }
//    }
}
