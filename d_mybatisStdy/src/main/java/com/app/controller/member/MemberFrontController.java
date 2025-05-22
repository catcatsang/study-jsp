package com.app.controller.member;

import java.io.IOException;

import com.app.Action;
import com.app.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		// http://localhost:8080/myapp/user/list 여기서
		//		http://localhost:8080 이걸 잘라서 보면 uri이다. 
		//		클라이언트가 요청한 정보가 담겨있다.
		String target = uri.substring(0, uri.lastIndexOf(".")).replace(req.getContextPath(), "");
		Result result = null;
		
		if(target.equals("/join")) {
			result = new JoinController().execute(req, resp);
		}else if(target.equals("/join-ok")) {
			result = new JoinConrollerOK().execute(req, resp);
		}
		
		if(result != null) {
			if(result.isForward()) {
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}else {
				resp.sendRedirect(result.getPath());
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
