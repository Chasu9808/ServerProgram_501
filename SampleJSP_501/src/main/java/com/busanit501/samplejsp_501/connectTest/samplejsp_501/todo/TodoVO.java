package com.busanit501.samplejsp_501.connectTest.samplejsp_501.todo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@NoArgsConstructor
@Setter
//@RequiredArgsConstructor
@AllArgsConstructor
public class TodoVO {
    private long tno;
    private String title;
    private LocalDate duedate;
    private boolean finished;
}
