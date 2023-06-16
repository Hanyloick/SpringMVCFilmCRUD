<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styles.css" />	
<title>Insert title here</title>
<body>
	<c:choose>
		<c:when test="${! empty film}">
			<table class="table">
				<c:forEach items="${film}" var="film">
					<tr>
						<td>Film Id:</td>
						<td>${film.filmId}</td>
					</tr>
					<tr>
						<td>Title:</td>
						<td>${film.title}</td>
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
						<td>Language ID:</td>
						<td>${film.langId}</td>
					</tr>
					<tr>
						<td>Rate:</td>
						<td>${film.rate}</td>
					</tr>
					<tr>
						<td>Cast:</td>
						<td>
							<ul>
								<c:forEach items="${film.cast}" var="actor">
									<li>${actor.firstName} ${actor.lastName}</li>						
								</c:forEach>
							</ul>
						</td>
					</tr>
					<c:if test="${! empty film}">
						<tr>
							<td>
								<form action="editFilm.do" method="GET">
	        						<button class="btn" type="submit">Edit Film</button>
	        						<input type="hidden" name="filmId" value="${film.filmId}" />
	    						</form>
    						</td>
    					</tr>	
					</c:if>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>
	<a href="index.html"><button class="btn">back home</button></a>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
