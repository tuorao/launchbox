<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
----------------회원 가입 -----------<br>
<form method="post" action="user/join">
id = <input type="text" name="storeSrls"><br>
pass = <input type="text" name="email"><br>


submit = <input type="submit" value="submit"><br>
</form>
----------------회원 가입 -----------<br>
<form action="order/input" method="post">
userSrl : <input type="text" name="userSrl"><br>
itemSrl : <input type="text" name="itemSrl"><input type="text" name="itemAmount"><br>
itemSrl : <input type="text" name="itemSrl"><input type="text" name="itemAmount"><br>
itemSrl : <input type="text" name="itemSrl"><input type="text" name="itemAmount"><br>
amount : <input type="text" name="amount"><br>
<input type="submit" value="submit">
</form>
<form action="order/UserBuyList" method="post">
userSrl : <input type="text" name="userSrl">
<input type="submit" value="submit">
</form>
<form action="order/pullPhase" method="get">
페이즈호출 : <input type="text" name="phase">
<input type="submit" value="submit">
</form>
<form action="order/pushInput" method="get">
안드키 : <input type="text" name="orderSrl">
<input type="submit" value="submit">
</form>
<form action="user/confirmPhone" method="post">
유저srl : <input type="text" name="userSrl">
<input type="submit" value="submit">
</form>

</body>
</html>
