<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>

	<form action="insertBoard.do">
		제목: <input type="text" name="title"> <br><br>	
		내용: <input type="text" name="content"> <br>	<br>
		작성자: <input type="text" name="writer" value="${member.name}" readonly> <br><br>
		<input type="submit" value="작성">	
	</form>

</body>
</html>