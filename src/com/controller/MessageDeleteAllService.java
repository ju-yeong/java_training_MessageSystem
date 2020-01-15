package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.front.Icommand;
import com.model.MemberDTO;
import com.model.MessageDAO;

public class MessageDeleteAllService implements Icommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDTO info = (MemberDTO)session.getAttribute("info");
		String email = info.getEmail();
		
		MessageDAO dao = new MessageDAO();
		dao.deleteAll(email);
		
		return "main.jsp";
	}

}
