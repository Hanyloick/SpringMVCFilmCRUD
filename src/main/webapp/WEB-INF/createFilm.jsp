<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AddFilm</title>
</head>
<body>
	<h3>Add a New Film</h3>
	<form action="createFilm.do" method="POST">

		<label for="title">Title:</label> 
			<input type="text" name="title" required='true' /> <br>
		
		<label for="description">Description: </label>
			<input type="text" name="description" /> <br>
			
		<label for="release year">Release Year: </label>
			<input type="number" name="releasYear" min='1900' /> <br>
			
		<label for="release year">Language: </label>
			<input type="number" name="langId" min='1' max='6' value='1' /> <br>
			
		<label for="renal duration">Rental Duration: </label>
			<input type="number" name="rentalDuration" value="3" /> <br> 
			
		<label for="rental rate">Rental Rate: </label>
			<input type="number" name="rental_rate" value="1.85" /> <br> 
			
		<label for="length">Length: </label>
			<input type="number" name="length" value="90" /> <br> 
			
		<label for="replacement cost">Replacement Cost: </label>
			<input type="number" name="replacement_cost" value="20" /> <br> 
			
		<label for="rating">Rating:</label> 
			<select id="rating" name="rating">
				<option value="G">G</option>
				<option value="PG">PG</option>
				<option value="PG13">PG13</option>
				<option value="NC17">NC17</option>
				<option value="R">R</option>
			</select> 
			<br>
		
		<input type="submit" name="Add New Film" />

	</form>

</body>
</html>