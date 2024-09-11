package com.aloha.DAO;

import java.sql.SQLException;

public class BoardDAO {
    
    /**
	 * 게시글 삭제
	 * @param no
	 * @return
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
