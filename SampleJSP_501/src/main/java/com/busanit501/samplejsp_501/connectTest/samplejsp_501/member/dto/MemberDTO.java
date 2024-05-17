package com.busanit501.samplejsp_501.connectTest.samplejsp_501.member.dto;

import java.time.LocalDate;

public class MemberDTO {
    // 인스턴스 멤버.
    private Long memno;
    private String memname;
    private LocalDate memDate;
    private boolean finished;

    public Long getMemno() {
        return memno;
    }

    public void setMemno(Long memno) {
        this.memno = memno;
    }

    public String getMemname() {
        return memname;
    }

    public void setMemname(String memname) {
        this.memname = memname;
    }

    public LocalDate getMemDate() {
        return memDate;
    }

    public void setMemDate(LocalDate memDate) {
        this.memDate = memDate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memno=" + memno +
                ", memname='" + memname + '\'' +
                ", memDate=" + memDate +
                ", finished=" + finished +
                '}';
    }
}










