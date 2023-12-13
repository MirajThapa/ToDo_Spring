package com.example.todo.services;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo createTask(Todo todo){
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTask(){
        return todoRepository.findAll();
    }

    public Todo updateTask(Todo task1){
        return todoRepository.save(task1);
    }

    public void deleteTask(Todo id){
        todoRepository.delete(id);
    }

    public Todo getUserById(int id) {
        return todoRepository.findById(id).orElse(null);
    }

}
