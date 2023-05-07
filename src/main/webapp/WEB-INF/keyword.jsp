<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles.css" />
<title>Insert title here</title>
<body>
	<c:choose>
		<c:when test="${! empty filmList}">

			<ul>
				<c:forEach items="${filmList}" var="film">

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


</body>
</html>