package com.tacademy.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tacademy.board.vo.Board;

public class BoardDAO {
	private static final String insertSQL = "INSERT INTO BOARD( TITLE, WRITER, CONTENT) VALUES(?, ?, ?);";
	private static final String listSQL = "select * from BOARD order by seq desc;";
	private static final String selectSQL = "select * from board where seq = ?";
	private static final String updateSQL = "update board set title = ?, content = ? where seq = ?";
	private static final String deleteSQL = "delete from board where seq = ?";
	
	public void deleteBoard(Board board){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(deleteSQL);
			stmt.setString(1, board.getSeq());
			int cnt = stmt.executeUpdate(); //cnt는 영향받은 레코드 수
			if(cnt>0){
				System.out.println("delete success");
			}else{
				System.out.println("delete fail");
			}
		} catch (SQLException e) {
			System.out.println("delete insert error : " + e);
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void updateBoard(Board board){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(updateSQL);
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getContent());
			stmt.setString(3, board.getSeq());
			int cnt = stmt.executeUpdate(); //cnt는 영향받은 레코드 수
			if(cnt>0){
				System.out.println("update success");
			}else{
				System.out.println("update fail");
			}
		} catch (SQLException e) {
			System.out.println("board insert error : " + e);
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void getBoard(Board board){
		
		Connection conn = null;
		PreparedStatement stmt =null;
		ResultSet rst = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(selectSQL);
			stmt.setString(1, board.getSeq());
			rst = stmt.executeQuery();
			if(rst.next()){
				board.setTitle(rst.getString(2));
				board.setWriter(rst.getString(3));
				board.setContent(rst.getString(4));
				board.setDatetime(rst.getString(5));
				board.setCnt(rst.getInt(6));
			}
		}catch(SQLException e){
			System.out.println("select error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
	}
	
	public ArrayList<Board> getBoardList(Board board1){ //검색시 값 전달용
		ArrayList<Board> list = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement stmt =null;
		ResultSet rst = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(listSQL);
			rst = stmt.executeQuery();
			Board board = null;
			while(rst.next()){
				board = new Board();
				board.setSeq(rst.getInt(1)+"");
				board.setTitle(rst.getString(2));
				board.setWriter(rst.getString(3));
				board.setContent(rst.getString(4));
				board.setDatetime(rst.getString(5));
				board.setCnt(rst.getInt(6));
				list.add(board);
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
		
		return list;
	}

	public void doInsertBoard(Board board) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(insertSQL);
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getWriter());
			stmt.setString(3, board.getContent());
			int cnt = stmt.executeUpdate(); //cnt는 영향받은 레코드 수
			if(cnt>0){
				System.out.println("insert success");
			}else{
				System.out.println("insert fail");
			}
		} catch (SQLException e) {
			System.out.println("board insert error : " + e);
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
}
