package com.app.controller.post;

import java.io.IOException;

import com.app.Action;
import com.app.Result;
import com.app.domain.vo.MemberVO;
import com.app.domain.vo.PostVO;
import com.app.repository.member.PostDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class WriteOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		PostVO postVO = new PostVO();
		PostDAO postDAO = new PostDAO();
		MemberVO memberVO = new MemberVO();
		HttpSession session = req.getSession();

//		Long memberId = Long.parseLong(session.getId()); 

		MemberVO member = (MemberVO) session.getAttribute("member");
		System.out.println(member);

		Long id = member.getId();
		String postTitle = req.getParameter("post-name");
		String postContent = req.getParameter("post-content");
		
		
		postVO.setMemberId(id);
		postVO.setPostTitle(postTitle);
		postVO.setPostContent(postContent);
		System.out.println(postVO);

		postDAO.insert(postVO);

		result.setPath("/mypage.member");
		
		return result;
	}

}
