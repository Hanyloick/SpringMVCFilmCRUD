<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styles.css" />
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>	
</body>
</html>