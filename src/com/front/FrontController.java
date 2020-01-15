package com.front;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.ElseService;
import com.controller.JoinService;
import com.controller.LoginService;
import com.controller.LogoutService;
import com.controller.MessageDeleteAllService;
import com.controller.MessageDeleteService;
import com.controller.MessageInsertService;
import com.controller.UpdateService;
import com.model.MemberDAO;
import com.model.MemberDTO;
import com.model.MessageDAO;
import com.model.MessageDTO;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	
	HashMap<String, Icommand> map = new HashMap<String, Icommand>();    // HashMap<key, value> : key�� �ߺ� �Ұ�, value�� �ߺ� ����
	
	@Override
	public void init() throws ServletException { // ���� ���� �� ȣ�� �Ǵ� �޼ҵ�
		map.put("JoinService.do", new JoinService());
		map.put("LoginService.do", new LoginService());
		map.put("LogoutService.do", new LogoutService());
		map.put("UpdateService.do", new UpdateService());
		map.put("MessageInsertService.do", new MessageInsertService());
		map.put("MessageDeleteAllService.do", new MessageDeleteAllService());
		map.put("MessageDeleteService.do", new MessageDeleteService());
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String requestURI = request.getRequestURI(); // Ŭ���̾�Ʈ�� ��û�� ��ü uri�� Ȯ���� �� ����
		String contextPath = request.getContextPath(); // ���ø����̼� �̸�
		String path = requestURI.substring(contextPath.length()+1);
		
		String moveURL = "";
		
		Icommand command = map.get(path); // �������̽��� ��ü�� ������ �� ������ ���۷��������� �����ؼ� �ּҸ� ������ �� ����. ��ü ������ ���� Ŭ��������! 
		moveURL = command.execute(request, response);
		response.sendRedirect(moveURL);
	}
}
