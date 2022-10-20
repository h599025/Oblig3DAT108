<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title> Min Handleliste </title>
</head>
<body>
<h1>Min Handleliste</h1>


<form action="leggtil" method="post">
        <input type="submit" value="Legg til"/>
        <input type="text" name="vare" required/><br>
</form>
<c:forEach var="vare" items="${varer}">
<form action="fjern" method="post">
    <input type="submit" value="fjern"/>
    <input type="hidden" value="${vare}" name="vare">
    <span><c:out value="${vare}"/> </span>
</form>
</c:forEach>
</body>
</html>