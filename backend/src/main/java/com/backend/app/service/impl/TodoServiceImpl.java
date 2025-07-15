package com.backend.app.service.impl;

import com.backend.app.dto.TodoRequest;
import com.backend.app.dto.TodoResponse;
import com.backend.app.entity.Todo;
import com.backend.app.exception.ResourceNotFoundException;
import com.backend.app.repository.TodoRepository;
import com.backend.app.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final ModelMapper modelMapper;
    private final TodoRepository todoRepository;


    @Override
    public TodoRequest addTodo(TodoRequest todoRequest) {
        Todo todo = modelMapper.map(todoRequest, Todo.class);
        Todo savedTodo = todoRepository.save(todo);
        return modelMapper.map(savedTodo, TodoRequest.class);
    }

    @Override
    public TodoResponse getTodo(Integer id) {
        Todo todo= todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo không tìm thấy với Id: " +id));
        return modelMapper.map(todo, TodoResponse.class);
    }

    @Override
    public List<TodoResponse> getAllTodo() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(todo->modelMapper.map(todo,TodoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public TodoRequest updateTodo(TodoRequest todoRequest, Integer id) {
        Todo todo=todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Không tìm thấy id:"+id));
        modelMapper.map(todoRequest,todo);
        Todo updated=todoRepository.save(todo);
        return modelMapper.map(updated,TodoRequest.class);
    }

    @Override
    public void deleteTodo(Integer id) {
        Todo todo= todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("không tìm thấy ID :"+id));
        todoRepository.deleteById(id);
    }

    @Override
    public TodoResponse completeTodo(Integer id) {
        Todo todo = todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Không tìm thấy id"+id));
        todo.setCompleted(true);
        Todo updateTodo = todoRepository.save(todo);
        return modelMapper.map(updateTodo,TodoResponse.class);
    }

    @Override
    public TodoResponse incompleteTodo(Integer id) {
        Todo todo =todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Khong tim thay id:"+id));
        todo.setCompleted(false);
        Todo updateTodo= todoRepository.save(todo);
        return modelMapper.map(updateTodo,TodoResponse.class);
    }


    public TodoRequest addTodoBasic(TodoRequest todoRequest){
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

    public TodoResponse getTodoBasic(Integer id){
        Todo todo=todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Khong tim thay id"+id));
        TodoResponse response = new TodoResponse();
        response.setTitle(todo.getTitle());
        response.setDescription(todo.getDescription());
        response.setCompleted(todo.isCompleted());
        return response;
    }

    public TodoRequest updateTodoBasic(TodoResponse todoResponse,Integer id){
        Todo todo = new Todo();
        todo.setTitle(todoResponse.getTitle());
        todo.setDescription(todo.getDescription());

        Todo updateTodo=todoRepository.save(todo);

        TodoRequest response= new TodoRequest();
        response.setTitle(updateTodo.getTitle());
        response.setDescription(updateTodo.getDescription());
        return response;
    }

    public TodoRequest deletedTodoBasic(Integer id){
        Todo todo = todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("khong tim thay id:"+id));
        todoRepository.deleteById(id);
        TodoRequest response = new TodoRequest();
        response.setTitle(todo.getTitle());
        response.setDescription(todo.getDescription());
        return response;

    }
}
