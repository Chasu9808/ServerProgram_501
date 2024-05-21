package com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.Controller;


import com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.dto.LunchDTO;
import com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.service.LunchService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "lunchReg", urlPatterns = "/lunch/register")
public class LunchRegController extends HttpServlet {

    //주입 , 서비스 인스턴스 , 포함.
    private LunchService lunchService  = LunchService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo 글 입력 폼
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lunchmenu/lunchReg.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // todo 글 입력 처리 하는 로직.
        // TodoDTO 타입을 받아서, 서비스에 전달하는 로직.
        LunchDTO lunchDTO = LunchDTO.builder()
                .menuTitle(req.getParameter("MenuTitle"))
                .menuRegDate(LocalDate.parse(req.getParameter("MenuRegDate")))
                .build();

        // 실제 데이터 입력하기.
        try {
            lunchService.register2(lunchDTO);
            // 리다이렉트, 메인: 리스트
            resp.sendRedirect("/lunch/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}







