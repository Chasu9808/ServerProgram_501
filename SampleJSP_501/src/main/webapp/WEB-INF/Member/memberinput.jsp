<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP-Model2(MVC)-MenuInput</title>
</head>
<body>
<h1><%= "임시 MenuInput 화면." %>
</h1>
<form method="post" action="/member/input ">
    <input type="text" name="menu1" placeholder="이름1 입력해주세요">
    <input type="text" name="menu2" placeholder="이름2 입력해주세요">
    <button type="submit">임시 name 등록</button>
</form>
</body>
</html>