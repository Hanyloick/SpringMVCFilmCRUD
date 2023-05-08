<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>confirm</title>
</head>
<body>
	<c:if test="${! empty film}"/>
	<h1>ahh</h1>
	<c:otherwise>
	<p>Save failed</p>
	</c:otherwise>	
	<a href="index.html">Home</a>
</body>
</html>