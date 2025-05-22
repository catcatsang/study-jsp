package com.app.controller.member;

import java.io.IOException;

import com.app.domain.vo.MemberVO;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberDAO memberDAO = new MemberDAO();
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		
		
	    
	}
}
