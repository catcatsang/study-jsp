package com.app.controller.member;

import java.io.IOException;

import com.app.domain.vo.MemberVO;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MyPageUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/templates/member/mypage").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO memberVO = new MemberVO();
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = (MemberVO) session.getAttribute("member");

//	   MEMBER_EMAIL, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_GENDER,

		Long id = member.getId();
		String Email = member.getEmail();
		String Password = member.getPassword();
		String Age = member.getPassword();
		String Gender = member.getGender();

		Email = req.getParameter("memberEmail");
		Password = req.getParameter("memberPassword");
		Age = req.getParameter("memberAge");
		Gender = req.getParameter("memberGender");
		int memberAge = Integer.parseInt(Age);

		memberVO.setEmail(Email);
		memberVO.setPassword(Password);
		memberVO.setAge(memberAge);
		memberVO.setPassword(Password);

		memberDAO.insert(memberVO);
		memberDAO.update(memberVO);

		resp.sendRedirect("/templates/member/mypage");
	}
}
