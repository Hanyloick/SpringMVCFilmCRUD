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
	<form:form action="editfilm.do" method="POST" modelAttribute="film">
		<input type="hidden" value="${film.filmId}" name="filmId" />
		<label for="title">Title</label>
		<input type="text" name="title" value="${film.title}" />
		<label for="Description">Description</label>
		<input type="text" name="description" />
		<label for="Language ID">Language ID</label>
		<input type="text" name="langId" />
		<label for="Rating">Rating</label>
		<input type="text" name="rating" />
		<label for="Rental Rate">Rental Rate</label>
		<input type="text" name="rate" />
		<label for="Rental Duration">Rental Duration</label>
		<input type="text" name="rentalDuration" />
		<input type="submit" name="editfilm">
	</form:form>
	
	<a href="index.html">Home</a>
	
	<form:form action = "filmDelete.do" method = "POST" modelAttribute="film">
  	<input type = "hidden" name = "delete" value="${film.filmId}"/>
  	<input type = "submit" value = "Delete Film"/>
  	</form:form>
</body>
</html>