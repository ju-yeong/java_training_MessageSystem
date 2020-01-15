package com.model;

public class MessageDTO {
	private int num;
	private String sene_name;
	private String receive_email;
	private String content;
	private String day;
	
	public MessageDTO(int num, String sene_name, String receive_email, String content, String day) {
		this.num = num;
		this.sene_name = sene_name;
		this.receive_email = receive_email;
		this.content = content;
		this.day = day;
	}

	
	public MessageDTO(String sene_name, String receive_email, String content) {
		this.sene_name = sene_name;
		this.receive_email = receive_email;
		this.content = content;
	}


	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSene_name() {
		return sene_name;
	}
	public void setSene_name(String sene_name) {
		this.sene_name = sene_name;
	}
	public String getReceive_email() {
		return receive_email;
	}
	public void setReceive_email(String receive_email) {
		this.receive_email = receive_email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
}
