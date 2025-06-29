package com.hjc.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateTodoListDto {
    @NotBlank
    private String name;
    private Integer status;
    @NotBlank
    private String content;
}
