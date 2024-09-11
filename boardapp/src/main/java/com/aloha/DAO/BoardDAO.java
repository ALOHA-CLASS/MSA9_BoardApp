package com.aloha.DAO;

import com.aloha.DTO.Board;
import java.sql.SQLException;

public class BoardDAO extends JDBC {

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
}
