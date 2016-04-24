<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<link rel="stylesheet" href = "board.css">
</head>
<body>
<div id="main">
<h1>로그인</h1>
<form action="login.do" method="post"> <!-- 원래는 login logout 서블릿으로 만들어야 하는데 Member서블릿으로 만듦
action의 member는 web.xml에서 정의하는 서블릿 네임 -->
	<table id="table1">
	<tr><td>아이디</td>
	    <td><input type="text" name="id"/></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="password"/></td>
	</tr>
	<tr><td colspan="2" align="center"><input type="submit" value="로그인"/></td></tr>
	</table>
</form>
</div>
</body>
</html>