package com.app.controller.member;

import java.io.IOException;

import org.apache.ibatis.javassist.compiler.ast.Member;

import com.app.Action;
import com.app.Result;
import com.app.domain.vo.MemberVO;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinConrollerOK implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok 들어옴");
		Result result = new Result();
		MemberVO memberVO = new MemberVO();
		MemberDAO memberDAO = new MemberDAO();
		System.out.println("두번째드렁옴");
		
		String email = req.getParameter("memberEmail");
		String password = req.getParameter("memberPassword");
		String name = req.getParameter("memberName");
		int age = Integer.parseInt(req.getParameter("memberAge"));
		String gender = req.getParameter("memberGender");
		
		
		
		System.out.println("값을 가져옴");
		System.out.print("email: " + email); 
		System.out.println("password: " + password);
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		 System.out.println("gender: " + gender);

		memberVO.setMemberEmail(email);
		memberVO.setMemberPassword(password);
		memberVO.setMemberAge(age);
		memberVO.setMemberName(name);
		memberVO.setMemberGender(gender);

		memberDAO.insert(memberVO);
		
		System.out.println(memberVO);

		result.setPath("/join.member");

		return result;
	}

}
