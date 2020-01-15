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
	
	HashMap<String, Icommand> map = new HashMap<String, Icommand>();    // HashMap<key, value> : key는 중복 불가, value는 중복 가능
	
	@Override
	public void init() throws ServletException { // 서블릿 생성 시 호출 되는 메소드
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
		
		String requestURI = request.getRequestURI(); // 클라이언트가 요청한 전체 uri를 확인할 수 있음
		String contextPath = request.getContextPath(); // 어플리케이션 이름
		String path = requestURI.substring(contextPath.length()+1);
		
		String moveURL = "";
		
		Icommand command = map.get(path); // 인터페이스는 객체를 생성할 수 없지만 레퍼런스변수를 생성해서 주소를 저장할 수 있음. 객체 구현은 각각 클래스에서! 
		moveURL = command.execute(request, response);
		response.sendRedirect(moveURL);
	}
}
