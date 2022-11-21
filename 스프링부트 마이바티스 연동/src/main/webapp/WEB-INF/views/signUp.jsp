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

<form action="signUp" method="post">
    <input type="text" name="mid" placeholder="아이디 입력" required>
    <input type="text" name="mpw" placeholder="비밀번호 입력" required>
    <input type="text" name="mname" placeholder="이름 입력" required>
    <input type="submit" value="등록">
</form>

<a href="login">로그인 화면으로</a>

</body>