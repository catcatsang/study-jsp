package com.app.controller.member;

import java.io.IOException;
import java.lang.StackWalker.Option;
import java.util.Optional;

import com.app.domain.vo.MemberVO;
import com.app.exception.LoginFailException;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//public class LoginController extends HttpServlet {
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getRequestDispatcher("/templates/member/login.jsp").forward(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		MemberVO memberVO = new MemberVO();
//		MemberDAO memberDAO = new MemberDAO();
//
//		String emailString = req.getParameter("memberEmail");
//		String passWordString = req.getParameter("memberPassword");
//
//		memberVO.setEmail(emailString);
//		memberVO.setPassword(passWordString);
//
//		Optional<MemberVO> foundMember = memberDAO.selectByMemberEmailAndMemberPassword(memberVO);
//		System.out.println(foundMember);
//
//		resp.sendRedirect(foundMember.isPresent() ? "/member/mainPage" : "/member/");
//		
//		
//		
//		
//	}
//}

//    		강사님 코드 Zone

public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("login") != null) {
			req.setAttribute("login", false);
		}
		req.getRequestDispatcher("/templates/member/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		MemberVO member = null;

		String memberEmail = req.getParameter("memberEmail");
		String memberPassword = req.getParameter("memberPassword");

		memberVO.setEmail(memberEmail);
		memberVO.setPassword(memberPassword);

		Optional<MemberVO> foundMember = memberDAO.selectByMemberEmailAndMemberPassword(memberVO);

		try {
			member = foundMember.orElseThrow(() -> {
				throw new LoginFailException();
			});
			session.setAttribute("member", member);
			resp.sendRedirect("/member/mypage");
		} catch (LoginFailException e) {
			System.out.println("로그인 실패");
			resp.sendRedirect("/member/login?login=false");
		}
	}
}
