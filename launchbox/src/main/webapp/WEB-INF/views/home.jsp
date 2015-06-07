<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
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
userSrl : <input type="text" name="userSrl">
itemSrl : <input type="text" name="itemSrl">
itemSrl : <input type="text" name="itemSrl">
itemSrl : <input type="text" name="itemSrl">
<input type="submit" value="submit">
</form>
<form action="order/pullPhase1" method="post">
<input type="submit" value="submit">
</form>
</body>
</html>
