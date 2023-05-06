<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles.css" />
<title>Film</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty film}">
			<ul>
				<li>${film.title}</li>
				<li>${film.rating}</li>
				<li>${film.description}</li>
				<li>${film.releaseYear}</li>
				<li>${film.length}</li>
				<li>${film.replacementCost}</li>
				<li>${film.langId}</li>
				
			</ul>
		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>
	<a href="index.html">back home</a>
	<a href="editfilm.html">edit film</a>
</body>
</html>