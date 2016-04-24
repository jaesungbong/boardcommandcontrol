<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>새글등록</title>
<link rel="stylesheet" href = "board.css">
</head>
<body>
<div class="main">
<h3>
	새글 등록하기............<a href='logout.do'>LOG-OUT</a>
</h3>
<hr>
<form action='addBoard.do' method="post">
	<input type="hidden" name="action" value="addBoard">
	<table id="table1">
		<tr>
			<td>제목</td>
			<td align="left"><input type="text" name="title" /></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td align="left"><input type="text" name="writer" size="10" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				value=" 새글 등록 " /></td>
		</tr>
	</table>
</form>
<hr>
</div>
</body>
</html>