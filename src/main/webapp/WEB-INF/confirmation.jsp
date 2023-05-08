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
	<c:choose>
		<c:when test="${! empty film}">
			<ul>
				<li>${film.title}</li>
				<li>${film.rating}</li>
				<li>${film.description}</li>
				<li>${film.releaseYear}</li>
				<li>${film.length}</li>
				<li>${film.replacementCost}</li>
				<li>${film.category}</li>
				<li>${film.langId}</li>
				<li>${film.language }</li>
				<c:forEach items='${film.cast}' var='actor'>
					<li>${actor.firstName} ${actor.lastName}</li>
					
				</c:forEach>
						
				
				
			</ul>
		</c:when>
		<c:otherwise>
			<p>Your edit was unsuccessful</p>
		</c:otherwise>
		</c:choose>	
	<a href="index.html">Home</a>
</body>
</html>