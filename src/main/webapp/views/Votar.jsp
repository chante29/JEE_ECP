<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VotarView</title>
</head>
<body>
	<h2>
		Vista de <b>Votar</b>
	</h2>
	<c:set var="votarBean" scope="request" value="${Votar}" />
	<div>${votarBean.update()}</div>
	<c:choose>
	
	<c:when test="${votarBean.temas.size() == 0}">
		<h2>No hay ning&uacute;n tema para votar</h2>
	</c:when>
	<c:otherwise>
	<p>
			Temas: <select name="tema">
				<c:forEach var="tema" items="${votarBean.temas}">
					<option value="${tema.id}">${tema.nombre_tema}</option>
				</c:forEach>
			</select>
		</p>
	</c:otherwise>
	</c:choose>
	<br> 
	<a href="/JEE_ECP/faces/Home.jsp">Volver</a><br>
	
</body>
</html>