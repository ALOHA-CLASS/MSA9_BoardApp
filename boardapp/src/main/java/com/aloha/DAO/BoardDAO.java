package com.aloha.DAO;

import java.sql.SQLException;

import com.aloha.DTO.Board;

public class BoardDAO extends JDBC {
    public Board select(int no) {
		Board board = new Board();
		String sql = " SELECT * "
				   + " FROM board "
				   + " WHERE no = ? ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt( 1, no );		
			rs = psmt.executeQuery();
			
			if( rs.next() ) {
				board.setTitle( rs.getString("title") );
				board.setWriter( rs.getString("writer") );
				board.setContent( rs.getString("content") );
			}	
		} catch (SQLException e) {
			System.err.println("게시글 조회 오류");
			e.printStackTrace();
		}
		return board;
    }
}