package com.app.ex.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Ex05 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/ex05.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("user-id");
		String userPassword = req.getParameter("user-password");
		String result = "";
		if(userId.equals("test") && userPassword.equals("1234")) {
			
			req.setAttribute("result", userId + "님 환영합니다.");
			req.getRequestDispatcher("ex05-result.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("ex05.jsp");
		}
		
		
	}
}
