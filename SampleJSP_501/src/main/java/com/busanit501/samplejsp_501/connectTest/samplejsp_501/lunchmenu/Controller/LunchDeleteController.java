package com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.Controller;


import com.busanit501.samplejsp_501.connectTest.samplejsp_501.lunchmenu.service.LunchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "lunchDelete", urlPatterns = "/lunch/delete")
public class LunchDeleteController extends HttpServlet {
    // 처리
    private LunchService lunchService = LunchService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 삭제 처리하기.
        Long menuNo = Long.valueOf(req.getParameter("menuNo"));
        try {
            lunchService.deleteTodo(menuNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 임시 처리했다 치고, 리스트로
        resp.sendRedirect("/lunch/list");
    }
}







