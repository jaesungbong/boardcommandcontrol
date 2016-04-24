<%@page import="com.tacademy.board.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tacademy.board.dao.BoardDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- foreach문 쓰기 위해 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDAO dao = new BoardDAO();

	ArrayList<Board> list = dao.getBoardList(null);
%>
<c:set var="list" value="<%=list%>"/><!-- list변수를 사용하기 위해 -->
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
<link rel="stylesheet" href = "board.css">
</head>
<body>
<div id = "main">
<h1>글 리스트</h1>
<h3>${member.name }님 로그인 환영합니다......<!-- member.getName을 쓰지 않는 이유? -->
<a href="logout.do">Log-out</a></h3>
<table id = "table2">
<tr>
	<th id = "col1" width="100">번호</th>
	<th id = "col2" width="200">제목</th>
	<th id = "col3" width="150">작성자</th>
	<th id = "col4" width="150">등록일</th>
	<th id = "col5" width="100">조회수</th>
</tr>

<c:forEach var="board" items="${list}">
<tr>
	<td>${board.seq }</td>
	<td align="left"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
	<td>${board.writer }</td>
	<td>${board.datetime }</td>
	<td>${board.cnt }</td>
</tr>
</c:forEach>

</table>
<br>
<h4><a href="addBoard.jsp">새글 등록</a></h4>
</div>
</body>
</html>