<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Film</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styles.css" />
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>  	
</body>
</html>