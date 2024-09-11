package com.aloha.DAO;

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
}

