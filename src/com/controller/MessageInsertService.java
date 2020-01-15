package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.front.Icommand;
import com.model.MessageDAO;
import com.model.MessageDTO;

public class MessageInsertService implements Icommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String send_name = request.getParameter("send_name");
		String receive_email = request.getParameter("receive_email");
		String content = request.getParameter("content");
		
		MessageDTO dto = new MessageDTO(send_name, receive_email, content);
		MessageDAO dao = new MessageDAO();
		dao.insert(dto);
		
		return "main.jsp";
	}

}
