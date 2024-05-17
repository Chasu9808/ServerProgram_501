package MENU.dto;

import java.time.LocalDate;

public class MenuDTO {
    // 인스턴스 멤버.
    private Long mtno;
    private String mtitle;
    private LocalDate mdueDate;
    private boolean finished;

    public Long getMtno() {
        return mtno;
    }

    public void setMtno(Long mtno) {
        this.mtno = mtno;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public LocalDate getMdueDate() {
        return mdueDate;
    }

    public void setMdueDate(LocalDate mdueDate) {
        this.mdueDate = mdueDate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "mtno=" + mtno +
                ", mtitle='" + mtitle + '\'' +
                ", mdueDate=" + mdueDate +
                ", finished=" + finished +
                '}';
    }
}









