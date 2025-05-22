package com.app.controller.member;

import java.io.IOException;

import com.app.domain.vo.MemberVO;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinController extends HttpServlet{
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.getRequestDispatcher("/templates/member/join.jsp").forward(req, resp);
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      MemberVO memberVO = new MemberVO();
      MemberDAO memberDAO = new MemberDAO();
      
      
//      req.getParameter(LEGACY_DO_HEAD);		// 화면에서 받아오는 데이터
//      req.getAttribute(LEGACY_DO_HEAD);		// LEGACY_DO_HEAD라는 이름으로 저장된 값을 찾아서 가져오는 거예요
//      LEGACY_DO_HEAD 이름으로 저장된 값을 찾아서 가져오는것이다.
//      req.getRequestDispatcher(LEGACY_DO_HEAD); // LEGACY_DO_HEAD 의 경로로 forward 할떄 사용됨
//      
//      req.setAttribute(LEGACY_DO_HEAD, memberDAO); // LEGACY_DO_HEAD, 의 키값에 memberDAO 의 값을 저장.
//      
//      resp.sendRedirect(LEGACY_DO_HEAD);	// 이동하기 전의 페이지의 값들을 모두 초기화 한다음 LEGACY_DO_HEAD url 로 이동,
      
      
      
      
      String memberEmail = req.getParameter("memberEmail");
      String memberPassword = req.getParameter("memberPassword");
      String memberName = req.getParameter("memberName");
      int memberAge = Integer.parseInt(req.getParameter("memberAge"));
      String memberGender = req.getParameter("memberGender");
      
      memberVO.setEmail(memberEmail);
      memberVO.setPassword(memberPassword);
      memberVO.setName(memberName);
      memberVO.setAge(memberAge);
      memberVO.setGender(memberGender);
      
      memberDAO.insert(memberVO);
      
      resp.sendRedirect("/member/login");      
   }
}



















