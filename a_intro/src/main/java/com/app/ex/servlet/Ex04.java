package com.app.ex.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Ex04 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/ex04.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IN");
		String area1 = req.getParameter("area-name");
		System.out.println(area1);
		String area1Resulut = "";
		if(area1.equals("경기도")) {
			area1Resulut = "남양주시";
		}
		else if(area1.equals("서울")) {
			area1Resulut = "강남";
		}else{
			area1Resulut = "빈값";
		}
		req.setAttribute("result", area1Resulut);
		req.getRequestDispatcher("ex04-result.jsp").forward(req, resp);
			
		
		
	}
	
}
