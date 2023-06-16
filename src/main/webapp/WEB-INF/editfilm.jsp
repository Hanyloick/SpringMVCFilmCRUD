<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="container">
		<h1>Edit Film</h1>
		<form action="updateFilm.do" method="POST" modelAttribute="film">
			<input type="hidden" value="${film.filmId}" name="filmId" />
			
			<div class="form-group row">
				<label for="title" class="col-sm-2 col-form-label">Title</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="title" value="${film.title}" />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="description" class="col-sm-2 col-form-label">Description</label>
				<div class="col-sm-10">
					<textarea class="form-control" name="description">${film.description}</textarea>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="length" class="col-sm-2 col-form-label">Length</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="length" value="${film.length}" />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="langId" class="col-sm-2 col-form-label">Language ID</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="langId" value="1" />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="rating" class="col-sm-2 col-form-label">Rating</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="rating" placeholder="${film.rating}" />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="rate" class="col-sm-2 col-form-label">Rental Rate</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="rate" value="3" />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="rentalDuration" class="col-sm-2 col-form-label">Rental Duration</label>
				<div class="col-sm-10 input-group">
					<input type="text" class="form-control" name="rentalDuration" value="5" />
					<div class="input-group-append">
						<span class="input-group-text">Days</span>
					</div>
				</div>
			</div>
			
			<div class="form-group row">
				<div class="col-sm-2"></div>
				<div class="col-sm-10">
					<input type="submit" class="btn btn-primary" name="updateFilm" value="Update Film" />
				</div>
			</div>
		</form>
		
		<a href="index.html">Home</a>
		
		<form action="filmDelete.do" method="POST" modelAttribute="film">
			<input type="hidden" name="delete" value="${film.filmId}" />
			<input type="submit" class="btn btn-danger" value="Delete Film" />
		</form>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
