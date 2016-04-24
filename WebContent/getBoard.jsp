<%@page import="com.tacademy.board.dao.BoardDAO"%>
<%@page import="com.tacademy.board.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 내용</title>
<link rel="stylesheet" href = "board.css">
</head>
<body>
<div id="main">
		<h3>글 내용<br>
		<a href="logout.do">Log-out</a>
		</h3>
		<hr>
		<form action="updateBoard.do" method="post">
		<input type="hidden" name="seq" value="${board.seq }">
		<input type="hidden" name="action" value="updateBoard">
			<table id="table1" >
				<tr>
					<td>제목</td>
					<td align="left"><input name="title" type="text" value="${board.title }" /></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td align="left">${board.writer }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10">${board.content }</textarea></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td align="left">${board.datetime }</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td align="left">${board.cnt }</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="글 수정" /></td>
				</tr>
			</table>
			
		</form>
		<hr>
		<h4><a href="addBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp; <a
			href="board?action=deleteBoard&seq=${board.seq }">글삭제</a>&nbsp;&nbsp;&nbsp; <a
			href="getBoardList.jsp">리스트</a></h4>
</div>
</body>
</html>