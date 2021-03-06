package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todoService")
public class TodosServiceImpl implements TodosService{
    @Autowired
    TodoRepository todorepos;

    @Override
    public void markComplete(long todoid) {
        Todo todo = todorepos.findById(todoid).orElseThrow(() -> new EntityNotFoundException("Todo " + " Not Found"));
        todo.setCompleted(true);
    }

}
