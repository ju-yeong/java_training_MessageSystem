package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
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

	public void join(MemberDTO dto) {
		getConn();
		String sql = "insert into web_member values (?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getEmail());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getTel());
			psmt.setString(4, dto.getAddress());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public MemberDTO login(String input_email, String input_pw) {
		getConn();
		String sql = "select * from web_member where email=? and pw=?";
		MemberDTO info = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, input_email);
			psmt.setString(2, input_pw);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String email = rs.getString(1); // getString("email")처럼 컬럼인덱스가 아닌 컬럼명을 적어도 됨!!!!!
				String pw = rs.getString(2);
				String tel = rs.getString(3);
				String address = rs.getString(4);
				
				info = new MemberDTO(email, pw, tel, address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
				
		return info;
	}

	public int update(MemberDTO dto) {
		getConn();
		String sql = "update web_member set pw=?,tel=?,address=? where email=?";
		int cnt=0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPw());
			psmt.setString(2, dto.getTel());
			psmt.setString(3, dto.getAddress());
			psmt.setString(4, dto.getEmail());
			
			cnt = psmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
		
	}
}
