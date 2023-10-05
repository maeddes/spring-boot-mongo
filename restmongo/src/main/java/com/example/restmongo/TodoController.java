package com.example.restmongo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos/")
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/{todoName}")
    public Todo getTodoById(@PathVariable String todoName) {
        return todoRepository.findById(todoName).orElse(null);
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        List<Todo> todoList = new ArrayList<>();
        todoRepository.findAll().forEach(todoList::add);
        return todoList;
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @PostMapping("/{todoName}")
    public Todo createTodo(@PathVariable String todoName){

        Todo todo = new Todo();
        todo.setTodo(todoName);
        return todoRepository.save(todo);
    }

    @PutMapping("/{todoName}")
    public Todo updateTodo(@PathVariable String todoName, @RequestBody Todo updatedTodo) {
        if (todoRepository.existsById(todoName)) {
            updatedTodo.setTodo(todoName);
            return todoRepository.save(updatedTodo);
        } else {
            return null; // Handle not found
        }
    }

    @DeleteMapping("/{todoName}")
    public void deleteTodo(@PathVariable String todoName) {
        todoRepository.deleteById(todoName);
    }

}