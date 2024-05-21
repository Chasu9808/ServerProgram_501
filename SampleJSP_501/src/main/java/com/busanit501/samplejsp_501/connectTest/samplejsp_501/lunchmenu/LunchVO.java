package com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@NoArgsConstructor
@Setter
//@RequiredArgsConstructor
@AllArgsConstructor
public class LunchVO {
    private Long menuNo ;
    private String menuTitle ;
    private LocalDate menuRegDate ;
}

