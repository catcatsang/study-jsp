package com.app.ex.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Ex02 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/ex02.jsp").forward(req, resp);
//		get 은 단순페이지 이동이지만, 주소에 데이터를 전달하여 이동,
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String add1 = req.getParameter("add1");
		String add2 = req.getParameter("add2");
//		req.setAttribute("add", (int)add1 + (int)add2);
		int num1 = Integer.parseInt(add1);
		int num2 = Integer.parseInt(add2);
		int result = num1 + num2;
		req.setAttribute("add", "결과값" + result);
		req.getRequestDispatcher("add.jsp").forward(req, resp);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(result);

	}
}
