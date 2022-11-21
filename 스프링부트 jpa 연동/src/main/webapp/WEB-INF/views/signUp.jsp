<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1</title>
</head>
<body>

회원가입

<form action="insertM" method="post">
    <input type="text" name="pw" placeholder="비밀번호 입력" required>
    <input type="text" name="name" placeholder="이름 입력" required>
    <input type="submit" value="등록">
</form>

<a href="login">로그인 화면으로</a>

</body>