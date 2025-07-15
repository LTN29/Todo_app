package com.backend.app.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
//DÙNG KHI CLIENT GỬI DỮ LIỆU LÊN (POST ,PUT)
public class TodoRequest {
    String title;
    String description;
}
