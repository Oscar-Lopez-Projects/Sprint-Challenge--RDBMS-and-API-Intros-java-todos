package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long todoid;


    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean completed = false;


    //many to one
    @ManyToOne
    @JoinColumn(name = "userid",nullable = false)
    @JsonIgnoreProperties(value = "user")
    private User user;

    public Todo(User user,String description) {
        this.user = user;
        this.description = description;
    }

    public Todo() {
    }

    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
