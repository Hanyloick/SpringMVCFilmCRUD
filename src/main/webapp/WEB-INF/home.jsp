<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Film Site</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body>
	<h1>Spring MVC Film Site</h1>
	 <form action="film.do" method="GET">
    ID:
    
    <input type="text" name="id"/> 
    <input type="submit" value="Get Film Data" />
  	</form>
  	<form action="film.do" method="POST">
  	ADD A Film
  	Title:
  	<input type="text" name="title">
  	Description:
  	<input type="text" name="description">
  	Release Year:
  	<input type="text" name="releaseYear">
  	 Rate number:
  	<input type="text" name="rate">
  	Length number:
  	<input type="text" name="length">
  	Rent Duration:
  	<input type="text" name="rentalDuration"> 
  	Replacement cost:
  	<input type="text" name="replacementCost">
  	Language Id:
  	<input type="text" name="langId"> 
  	<input type="submit" name="Get Film Data">					 
  	</form>
  	<a href="film.do" name="edit">edit a film</a>
  	<form action = "filmDelete.do" method = "POST">
  	<label for ="id"> ID:</label>
  	<input type = "number" name = "delete"/>
  	<input type = "submit" value = "Delete Film"/>
  	</form>
  	

</body>
</html>