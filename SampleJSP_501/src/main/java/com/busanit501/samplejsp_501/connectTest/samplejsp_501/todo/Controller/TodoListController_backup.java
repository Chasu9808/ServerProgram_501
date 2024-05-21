package com.busanit501.samplejsp_501.connectTest.samplejsp_501.todo.Controller;

import com.busanit501.samplejsp_501.connectTest.samplejsp_501.todo.dto.TodoDTO;
import com.busanit501.samplejsp_501.connectTest.samplejsp_501.todo.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoList",urlPatterns = "/todo/list")
public class TodoListController_backup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 목록 화면으로 전달,
        List<TodoDTO> samplelist = TodoService.INSTANCE.getList();
        req.setAttribute("list",samplelist);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/todo/todoList.jsp");
        requestDispatcher.forward(req, resp);
    }
}