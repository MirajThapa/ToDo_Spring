package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ToDoListAppController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/createTodo")
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.createTask(todo);
    }

    @GetMapping("/todoList")
    public List<Todo> getAllUsers(){
        return todoService.getAllTask();
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<Todo> updateTasks(@RequestBody Todo todo,@PathVariable int id){
        Todo todo1 = todoService.getUserById(id);
        if (todo == null){
            return ResponseEntity.notFound().build();
        }
        todo1.setTitle(todo.getTitle());
        todo1.setDescription(todo.getDescription());
        Todo updateTodo = todoService.updateTask(todo1);
        return ResponseEntity.ok(updateTodo);
    }

    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable int id){
        Todo todo = todoService.getUserById(id);
        if (todo == null)
            return ResponseEntity.notFound().build();
        todoService.deleteTask(todo);
        return ResponseEntity.ok().build();
    }




}
