package com.tacademy.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tacademy.board.vo.Member;

public class MemberDAO {
	
	String loginSQL = "select name from member where id = ? and password = ?";
	
	public void doLogin(Member member){ //객체단위로 주고받자
		Connection conn = null;
		PreparedStatement stmt =null;
		ResultSet rst = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(loginSQL);
			stmt.setString(1, member.getId()); //쿼리문의 첫번째 물음표
			stmt.setString(2, member.getPassword()); //쿼리문의 두번째 물음표
			rst = stmt.executeQuery();//select는 쿼리
			if(rst.next()){
				member.setName(rst.getString("name"));
			}
		}catch(SQLException e){
			System.out.println("로그인 에러");
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
	}

}
