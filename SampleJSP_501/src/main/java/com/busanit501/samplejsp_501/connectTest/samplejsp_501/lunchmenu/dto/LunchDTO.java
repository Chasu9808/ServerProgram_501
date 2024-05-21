package com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@NoArgsConstructor
@Setter
//@RequiredArgsConstructor
@AllArgsConstructor
public class LunchDTO {
    private long menuNo ;
    private String menuTitle ;
    private LocalDate menuRegDate ;
}

