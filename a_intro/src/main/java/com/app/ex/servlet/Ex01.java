package com.app.ex.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Ex01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/ex01.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		req.setAttribute("name", name + "님");
//		set으로 req에 연산 값 저장
//		다음페이지로 넘어갈때까지가 req 의 영역이다.
//		 
		req.getRequestDispatcher("/result.jsp").forward(req, resp);
//		결과페이지에서도 req 에 저장, 
//		a -> 서블릿 -> req -> resp ->  -> b
	}
}
