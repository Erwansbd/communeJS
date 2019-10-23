<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>communes</title>
</head>
<body>
<h2>${titre }</h2>
<table>
	<c:forEach items="${communes }" var="commune">
		<tr><td>${commune.nom }</td>
			<td>${commune.codePostal }</td>
		</tr>
	</c:forEach>
</table>
<a href="index.jsp">Retour</a>
</body>
</html>