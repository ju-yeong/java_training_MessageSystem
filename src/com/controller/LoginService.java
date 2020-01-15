package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.front.Icommand;
import com.model.MemberDAO;
import com.model.MemberDTO;

public class LoginService implements Icommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String input_email = request.getParameter("email");
		String input_pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO info = dao.login(input_email, input_pw);
		
		if(info != null) { 
			HttpSession session = request.getSession();
			session.setAttribute("info", info);
		}
		return "main.jsp";
	}
	
}
