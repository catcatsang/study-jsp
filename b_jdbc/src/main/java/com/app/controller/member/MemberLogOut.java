package com.app.controller.member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberLogOut extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate(); 	// 세션 다날리기
//		req.getSession().removeAttribute(LEGACY_DO_HEAD); // 골라서 삭제
		
		resp.sendRedirect("/member/login");
	}
}
