package com.backend.app.controller;

import com.backend.app.dto.TodoRequest;
import com.backend.app.dto.TodoResponse;
import com.backend.app.service.TodoService;
import com.backend.app.service.impl.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController("todoController")
public class TodoController {

    private final TodoService todoService;


    public TodoController(@Qualifier("todoServiceImpl") TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/add")
    public ResponseEntity<TodoRequest> addTodo(@RequestBody TodoRequest todoRequest) {
        TodoRequest todoRequest1 = todoService.addTodo(todoRequest);
        return new ResponseEntity<>(todoRequest1, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TodoResponse> getById(@PathVariable  Integer id) {
        TodoResponse todoResponse = todoService.getTodo(id);
        return new ResponseEntity<>(todoResponse, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TodoRequest> updateTodo(@RequestBody TodoRequest todoRequest,@PathVariable Integer id) {
        TodoRequest todoRequest1 = todoService.updateTodo(todoRequest, id);
        return new ResponseEntity<>(todoRequest1, HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<List<TodoResponse>> getAll(){
        List<TodoResponse> listTodo =todoService.getAllTodo();
        return new ResponseEntity<>(listTodo,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Xoa thanh cong") ;
    }

}
