package com.aloha.DAO;


import java.sql.SQLException;

import com.aloha.DTO.Board;

public class BoardDAO extends JDBC {
    

	
	/**
	 * 데이터 목록
	 * @return
	 */
	public List<Board> list() {
		
		List<Board> boardList = new ArrayList<Board>();
		
		String sql = " SELECT * "
				   + " FROM board ";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {
				Board board = new Board();

				board.setNo( rs.getInt("no") );
				board.setTitle( rs.getString("title") );
				board.setWriter( rs.getString("writer") );
				board.setContent( rs.getString("content") );
				board.setRegDate( rs.getTimestamp("reg_date") );
				board.setUpdDate( rs.getTimestamp("upd_date") );
				
				boardList.add(board);
			}
			
		} catch (Exception e) {
			System.err.println("게시글 목록 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return boardList;
	}
  
  
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


