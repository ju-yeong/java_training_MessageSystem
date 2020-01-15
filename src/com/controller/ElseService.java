package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.front.Icommand;

public class ElseService implements Icommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "main.jsp";
	}
	
}
