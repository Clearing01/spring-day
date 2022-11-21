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
        아이디 <input type="text" name="mid" value="${member.mid}" readonly> <br>
        비밀번호 <input type="password" name="mpw" value="${member.mpw}" readonly> <br>
        이름 <input type="text" name="mname" value="${member.mname}"> <br>
        <input type="submit" value="수정">
    </form>

    <a href="deleteM?mid=${member.mid}">삭제</a>
</body>
</html>