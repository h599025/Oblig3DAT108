<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
</head>
<body>
	<p>${redirectMessage}</p>
	
	<form action="login" method="post">
		<input type="text" name="password"/><br>
		<input type="submit" value="Logg inn"/><br>
	</form>
</body>
</html>