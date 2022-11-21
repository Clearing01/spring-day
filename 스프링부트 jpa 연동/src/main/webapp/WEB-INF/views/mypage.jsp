<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HelloWorld!</title>
</head>
<body>
    <h1>마이 페이지</h1>

    <form action="updateM" method="post">
        아이디 <input type="text" name="id" value="${member.id}" readonly> <br>
        비밀번호 <input type="password" name="pw" value="${member.pw}" readonly> <br>
        이름 <input type="text" name="name" value="${member.name}"> <br>
        <input type="submit" value="수정">
    </form>

    <a href="deleteM?id=${member.id}">삭제</a>
</body>
</html>