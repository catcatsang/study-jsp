package com.app.controller.post;

import java.io.IOException;
import java.util.List;

import com.app.Action;
import com.app.Result;
import com.app.domain.vo.MemberVO;
import com.app.domain.vo.PostVO;
import com.app.repository.member.PostDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SelectController implements Action{

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		PostDAO postDAO = new PostDAO();
		HttpSession session = req.getSession();
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		
		
		List<PostVO> postList = postDAO.selectAll(member.getId());
		
		postList.forEach(System.out::println);
		
		req.setAttribute("post", postList);
		
		result.setPath("/templates/post/select.jsp");
		result.setForward(true);
		return result;
		
		
	}
	
}
