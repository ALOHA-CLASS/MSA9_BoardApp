package com.aloha.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aloha.DTO.Board;

public class BoardDAO extends JDBC {

	
	/**
	 * 데이터 목록
	 * @return
	 */
	public List<Board> list() {
		
		List<Board> boardList = new ArrayList<>();
		
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


    /**
     * 게시글 등록
     * @param board
     * @return
     */
    public int insert(Board board) {
        int result = 0;

        String sql = " INSERT INTO board( title, writer, content ) "
                   + " VALUES( ?, ?, ? ) ";

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, board.getTitle());
            psmt.setString(2, board.getWriter());
            psmt.setString(3, board.getContent());
            result = psmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("게시글 등록 중 예외 발생!");
        }

        return result;
    }


    /***
     * 데이터 수정
     */
    public int update(Board board){
        int result = 0;
        
        String sql = " update board"
						+"		set title = ?"
						+ "		,writer = ?"
						+ "		,content = ?"
						+ "		,upd_date = now()"
						+ "		,view=?"
						+ "	where no = ?"; 

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, board.getTitle());
            psmt.setString(2, board.getWriter());
            psmt.setString(3, board.getContent());
            psmt.setInt(4, board.getView());
            psmt.setInt(5, board.getView());
            result = psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("게시글 변경 시, 예외 발생");
            e.printStackTrace();
        }

        return result;
    }

    /*
     * 게시글 삭제
     */
    public int delete(int no){
        int result = 0;
        String sql = " DELETE FROM board "
                  + " WHERE no = ? ";
        try {
          psmt = con.prepareStatement(sql);			
          psmt.setInt( 1, no);						
          result = psmt.executeUpdate();				

        } catch (SQLException e) {
          System.err.println("게시글 삭제 시, 예외 발생");
          e.printStackTrace();
        }
        return result;
    }
}
