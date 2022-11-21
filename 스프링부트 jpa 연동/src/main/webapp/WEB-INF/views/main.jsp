<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelloWorld!</title>
</head>
<body>
    <h1>메인 화면</h1>
    안녕하세요 <a href="mypage">${member.name}</a>님 <br>

    <c:forEach var="d" items="${datas}">
        ${d.id} | ${d.pw} | ${d.name} <br>
    </c:forEach>

</body>
</html>