package com.backend.app;

import com.backend.app.controller.user.TodoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(BackendApplication.class, args);

        System.out.println("===== Danh sách tất cả Bean trong context =====");

        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames); // sắp xếp cho dễ nhìn

        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        System.out.println("===== Tổng số bean: " + beanNames.length + " =====");
    }
}

