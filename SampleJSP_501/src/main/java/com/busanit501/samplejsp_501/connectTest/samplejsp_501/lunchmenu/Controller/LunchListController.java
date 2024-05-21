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
import java.util.List;

@WebServlet(name = "lunchlist",urlPatterns = "/lunch/list")
public class LunchListController extends HttpServlet {

    //주입 , 서비스 인스턴스 , 포함.
    private LunchService lunchService = LunchService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // DB 에서 , 전체 목록을 가져오기.

        List<LunchDTO> sampleList = null;
        try {
            sampleList = lunchService.INSTANCE.listAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("list",sampleList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lunchmenu/lunchList.jsp");
        requestDispatcher.forward(req, resp);
    }
}







