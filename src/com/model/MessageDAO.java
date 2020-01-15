package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null) { rs.close(); }
			if (psmt != null) {	psmt.close(); }
			if (conn != null) {	conn.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(MessageDTO dto) {
		getConn();
		String sql = "insert into web_message values (web_num.nextval, ?,?,?, sysdate)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getSene_name());
			psmt.setString(2, dto.getReceive_email());
			psmt.setString(3, dto.getContent());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}

	public ArrayList<MessageDTO> select(String email) {
		ArrayList<MessageDTO> list = new ArrayList<MessageDTO>();
		
		getConn();
		String sql = "select * from web_message where receive_email = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String send_name = rs.getString(2);
				String receive_email = rs.getString(3);
				String content = rs.getString(4);
				String day = rs.getString(5);
				
				MessageDTO dto = new MessageDTO(num, send_name, receive_email, content, day);
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public void deleteAll(String email) {
		getConn();
		String sql = "delete from web_message where receive_email = ? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void delete(int num) {
		getConn();
		String sql = "delete from web_message where num=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	
	
	
	
}
