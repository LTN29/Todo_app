package com.backend.app.service.impl;

import com.backend.app.dto.TodoRequest;
import com.backend.app.dto.TodoResponse;
import com.backend.app.entity.Todo;
import com.backend.app.exception.ResourceNotFoundException;
import com.backend.app.repository.TodoRepository;
import com.backend.app.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class TodoServiceBasicImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public TodoRequest addTodo(TodoRequest todoRequest) {
        Todo todo=new Todo();
        todo.setTitle(todoRequest.getTitle());
        todo.setDescription(todoRequest.getDescription());
        Todo saveTodo=todoRepository.save(todo);
        //Trả về lại cho DTO To-doRequest
        TodoRequest response=new TodoRequest();
        response.setTitle(saveTodo.getTitle());
        response.setDescription(saveTodo.getDescription());
        return response;
    }

    @Override
    public TodoResponse getTodo(Integer id) {
        Todo todo=todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Khong tim thay id"+id));
        TodoResponse response = new TodoResponse();
        response.setTitle(todo.getTitle());
        response.setDescription(todo.getDescription());
        response.setCompleted(todo.isCompleted());
        return response;
    }

    @Override
    public List<TodoResponse> getAllTodo() {
        return List.of();
    }

    @Override
    public TodoRequest updateTodo(TodoRequest todoRequest, Integer id) {
        Todo todo = new Todo();
        todo.setTitle(todo.getTitle());
        todo.setDescription(todo.getDescription());

        Todo updateTodo=todoRepository.save(todo);

        TodoRequest response= new TodoRequest();
        response.setTitle(updateTodo.getTitle());
        response.setDescription(updateTodo.getDescription());
        return response;
    }

    @Override
    public void deleteTodo(Integer id) {

    }

    @Override
    public TodoResponse completeTodo(Integer id) {
        return null;
    }

    @Override
    public TodoResponse incompleteTodo(Integer id) {
        return null;
    }
}
