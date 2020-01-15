package com.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Icommand {
	// 인터페이스 : 강제성과 통일성을 줄 수 있음
	// 추상 메소드 : 기능이 없는 메소드, 자식에게 상속할때 사용
	
	public abstract String execute(HttpServletRequest request, HttpServletResponse response); // abstract 생략 가능
	
}
