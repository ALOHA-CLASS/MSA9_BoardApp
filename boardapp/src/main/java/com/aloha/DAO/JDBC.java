package com.aloha.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
    
    public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public JDBC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/aloha?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false";
			String id = "aloha";
			String pw = "123456";
			con = DriverManager.getConnection(url, id, pw);
			
			System.out.println("DB 접속 성공!");
		} catch (Exception e) {
			System.err.println("DB 접속 실패!");
		}
	}
    
}
