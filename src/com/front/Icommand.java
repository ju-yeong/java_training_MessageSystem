package com.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Icommand {
	// �������̽� : �������� ���ϼ��� �� �� ����
	// �߻� �޼ҵ� : ����� ���� �޼ҵ�, �ڽĿ��� ����Ҷ� ���
	
	public abstract String execute(HttpServletRequest request, HttpServletResponse response); // abstract ���� ����
	
}
