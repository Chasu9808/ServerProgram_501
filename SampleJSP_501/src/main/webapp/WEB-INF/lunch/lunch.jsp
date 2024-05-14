<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP2 - lunch.jsp</title>
</head>
<body>
<form action="/lunch-result" method="post">
  <input type="text" name="lunch" placeholder="점심메뉴를 입력해주세요">
<%--  <input type="number" name="mpw"placeholder="패스워드를 입력해주세요.">--%>
  <button type="submit">이걸로 결정!</button>
</form>

<form action="/lunch" method="get">
  <input type="text" name="lunch" placeholder="점심메뉴를 입력해주세요">
  <%--  <input type="number" name="mpw"placeholder="패스워드를 입력해주세요.">--%>
  <button type="submit">이걸로 결정!</button>
</body>
</html>
