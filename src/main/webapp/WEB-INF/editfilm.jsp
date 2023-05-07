<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="film.do" method="POST">
<input type="hidden" id="${film.filmId}" />
<input type="text" name="${film.title}"/>
<input type="text" name="${film.description}"/>
<input type="text" name="${film.langId}"/>
<input type="text" name="${film.rating}"/>
<input type="submit" name="editfilm">

</form>
</body>
</html>