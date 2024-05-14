package com.busanit501.samplejsp_501.lunch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "lunchController", urlPatterns = "/lunch")
public class lunchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 입력폼 전달
        System.out.println("get 으로 lunch 처리");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lunch/lunch.jsp");
        requestDispatcher.forward(req,resp);
    }

}







