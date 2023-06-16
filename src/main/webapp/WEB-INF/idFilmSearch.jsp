<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styles.css" />	
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles.css" />
<title>Film</title>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${! empty film}">
				<table class="table">
					<tr>
						<td>Title:</td>
						<td>${film.title}</td>
					</tr>
					<tr>
						<td>Rating:</td>
						<td>${film.rating}</td>
					</tr>
					<tr>
						<td>Description:</td>
						<td>${film.description}</td>
					</tr>
					<tr>
						<td>Release Year:</td>
						<td>${film.releaseYear}</td>
					</tr>
					<tr>
						<td>Length:</td>
						<td>${film.length}</td>
					</tr>
					<tr>
						<td>Replacement Cost:</td>
						<td>${film.replacementCost}</td>
					</tr>
					<tr>
						<td>Language:</td>
						<td>${film.language}</td>
					</tr>
					<tr>
						<td>Category:</td>
						<td>${film.category}</td>
					</tr>
					<tr>
						<td>Cast:</td>
						<td>
							<c:forEach items="${film.cast}" var="actor">
								${actor.firstName} ${actor.lastName}<br>
							</c:forEach>
						</td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<p>No film found</p>
			</c:otherwise>
		</c:choose>
		<c:if test="${! empty film}">
		<form action="editFilm.do" method="GET">
	        <button type="submit">Edit Film</button>
	        <input type="hidden" name="filmId" value="${film.filmId}" />
	    </form>
		</c:if>
	</div>
	<a href="index.html">back home</a>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
