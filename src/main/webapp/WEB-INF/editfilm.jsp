<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Film</title>
</head>
<body>
	<form:form action="updateFilm.do" method="POST" modelAttribute="film">
		<input type="hidden" value="${film.filmId}" name="filmId" />
		
		<label for="title">Title</label>		
		<input type="text" name="title" value="${film.title}" />
		
		<label for="Description">Description</label>
		<input type="text" name="description" value="${film.description}"/>
		
		<label for="length">Length</label>
		<input type="text" name="length" value="${film.length}"/>
		
		<label for="Language ID">Language ID</label>
		<input type="text" name="langId" value="1"/>
		
		<label for="Rating">Rating</label>
		<input type="text" name="rating" placeholder="${film.rating}"/>
		
		<label for="Rental Rate">Rental Rate</label>
		<input type="text" name="rate" value="3"/>
		
		<label for="Rental Duration">Rental Duration</label>
		<input type="text" name="rentalDuration" value="5"/>
		<span> Days</span>
		
		<input type="submit" name="updateFilm">
	</form:form>
	
	<a href="index.html">Home</a>
	
	<form:form action = "filmDelete.do" method = "POST" modelAttribute="film">
  	<input type = "hidden" name = "delete" value="${film.filmId}"/>
  	<input type = "submit" value = "Delete Film"/>
  	</form:form>
</body>
</html>