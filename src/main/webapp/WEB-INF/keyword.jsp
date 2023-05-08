<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

			<ul>
				<c:forEach items="${film}" var="film">

					<li>Film Id: ${film.filmId }</li>
					<li>Title: ${film.title }</li>
					<li>Description: ${film.description }</li>
					<li>Release Year: ${film.releaseYear }</li>
					<li>Length: ${film.length}</li>
					<li>Replacement Cost: ${film.replacementCost}</li>
					<li>Language ID: ${film.langId}</li>
					<li>Rate: ${film.rate }</li>
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
 <p>No film found</p>
 </c:otherwise>
	</c:choose>
	<a href = "index.html">back home</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>