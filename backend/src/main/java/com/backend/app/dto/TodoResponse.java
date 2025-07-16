package com.backend.app.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
//DÙNG KHI SEVER TRẢ DỮ LIỆU VỀ CHO CLIENT(GET, KẾT QUẢ POST,PUT)
public class TodoResponse {
    String title;
    String description;
    boolean completed;
}
