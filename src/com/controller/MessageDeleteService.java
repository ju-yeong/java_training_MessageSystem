package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.front.Icommand;
import com.model.MessageDAO;

public class MessageDeleteService implements Icommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		MessageDAO dao = new MessageDAO();
		dao.delete(num);
		return "main.jsp";
	}

}
