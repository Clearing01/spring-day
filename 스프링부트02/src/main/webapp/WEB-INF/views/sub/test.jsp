<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
</head>
<body>

${test} | ${name}
<br>
<c:forEach var="v" items="${datas}">
	${v} <br>
</c:forEach>

</body>
</html>