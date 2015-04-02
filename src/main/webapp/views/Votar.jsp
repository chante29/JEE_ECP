<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VotarView</title>
</head>
<body>
	<h2>
		Vista de <b>Votar</b>
	</h2>
	<c:set var="pVoto" scope="request" value="${Votar}" />
	<div>${pVoto.update()}</div>
	<p>
			Temas: <select name="tema">
				<c:forEach var="tema" items="${pVoto.temas}">
					<option value="${tema}">${tema}</option>
				</c:forEach>
			</select>
		</p>
</body>
</html>