package com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.Controller;


import com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.dto.LunchDTO;
import com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.service.LunchService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet(name = "lunchUpdate",urlPatterns = "/lunch/update")
public class LunchUpdateController extends HttpServlet {
    private LunchService lunchService = LunchService.INSTANCE;
    // 폼, 처리도

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 수정폼, 해당 게시글 번호에 대해서 수정폼을 열기.
            Long menuNo = Long.valueOf(req.getParameter("menuNo"));
            // menuNo 번호에 대한 해당 게시글 가져오기.
            LunchDTO sample = lunchService.getSelectOne(menuNo);
            //
            log.info("TodoListController , 확인2, sample : " + sample);
            // 화면에 전달하기. key : sample , 값 : 0x100
            req.setAttribute("sample", sample);
            req.getRequestDispatcher("/WEB-INF/lunchmenu/lunchUpd.jsp")
                    .forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //처리
        // 수정, 변경할 데이터를 먼저 가져오기. 콘솔에 찍어보기.
        Long menuNo = Long.valueOf(req.getParameter("menuNo"));

        String menuTitle = req.getParameter("menuTitle");

        LocalDate localDate = LocalDate.parse(req.getParameter("menuRegDate"));


        // 박스에 담기. DTO  담고, -> VO 변환.
        LunchDTO lunchDTO = LunchDTO.builder()
                .menuTitle(menuTitle)
                .menuRegDate(localDate)
                .menuNo(menuNo)
                .build();

        // 서비스에 전달하기.
        try {
            lunchService.updateTodo(lunchDTO);
            resp.sendRedirect("/lunch/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}







