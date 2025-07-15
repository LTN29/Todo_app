package com.backend.app.controller.user;

import com.backend.app.entity.Todo;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//Caused by: org.springframework.context.annotation.ConflictingBeanDefinitionException:
// Annotation-specified bean name 'todoController' for bean class [com.backend.app.controller.user.TodoController]
// conflicts with existing
// ,non-compatible bean definition of same name and class [com.backend.app.controller.TodoController]
@RestController("userTodoController")
@Lazy(value = false)
public class TodoController {
    private List<Todo> list= new ArrayList();

    @GetMapping("/user/getAll")
    public List<Todo> getALL(){
        Todo todo1 = new Todo(1,"AAA","ABC",true);
        Todo todo2 = new Todo(2,"AA1","ABC",true);
        list.add(todo1);
        list.add(todo2);
    return list;
    }

    @GetMapping("/user/getAll2")
    public List<Todo> getALL2(){
        return list;
    }

    @PostConstruct
    public void init() {

    }
    @PreDestroy
    public void cleanup() {
        System.out.println("🧹 Dọn dẹp trước khi bean bị hủy");
    }

    public TodoController() {
        System.out.println("contructor của todoController");
    }
}
