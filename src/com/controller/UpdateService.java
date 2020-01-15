package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.front.Icommand;
import com.model.MemberDAO;
import com.model.MemberDTO;

public class UpdateService implements Icommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String moveURL = "";
		HttpSession session = request.getSession();
		MemberDTO info = (MemberDTO)session.getAttribute("info");
		
		String email = info.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDTO dto = new MemberDTO(email, pw, tel, address);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.update(dto);
		
		if(cnt>0) {
			session.setAttribute("info", dto);			
			moveURL = "main.jsp";
		} else {
			moveURL = "update.jsp";
		}
		
		return moveURL;
	}

}
