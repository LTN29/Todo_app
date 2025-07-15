package com.backend.app.service;

import com.backend.app.dto.TodoRequest;
import com.backend.app.dto.TodoResponse;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface TodoService {
    //Thêm mới To_do
    TodoRequest addTodo(TodoRequest todoRequest);
    //Lấy 1 To_do theo ID
    TodoResponse getTodo(Integer id);
    //Lấy toàn bộ danh sách To_do
    List<TodoResponse> getAllTodo();
    //Chỉnh sửa To_do theo ID
    TodoRequest updateTodo(TodoRequest todoRequest,Integer id);
    //Xóa To_do Theo ID
    void deleteTodo(Integer id);
    //Đánh dấu đã hoàn thành
    TodoResponse completeTodo(Integer id);
    //Đánh dấu chưa hoàn thành
    TodoResponse incompleteTodo(Integer id);
}

