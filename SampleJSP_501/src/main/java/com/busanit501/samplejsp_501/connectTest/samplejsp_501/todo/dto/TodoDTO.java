package com.busanit501.samplejsp_501.connectTest.samplejsp_501.todo.dto;

import lombok.*;

import java.time.LocalDate;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TodoDTO {
    // 인스턴스 멤버.
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}