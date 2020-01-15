package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.front.Icommand;
import com.model.MemberDAO;
import com.model.MemberDTO;

public class JoinService implements Icommand {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDTO dto = new MemberDTO(email, pw, tel, address);
		MemberDAO dao = new MemberDAO();
		dao.join(dto);
		
		return "main.jsp";
	}
}
