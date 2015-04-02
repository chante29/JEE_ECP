<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AniadirView</title>
</head>
<body>
	<h2>
		Vista de <b>Aniadir</b>
	</h2>
	<c:set var="aniadirTemaBean" scope="request" value="${AniadirTema}" />
	<c:if test="${not empty aniadirTemaBean.error}">
	<h2>${aniadirTemaBean.error}</h2>
	</c:if>
	<form method="POST" action="/JEE_ECP/faces/jsp/AniadirTema">
		<label for="nombre_tema">Nombre del tema: </label>
		<input id="nombre_tema" name="nombre_tema" type="text" /><br />
		<label for="pregunta">Pregunta del tema: </label>
		<input id="pregunta" name="pregunta" type="text" value="${bean.tema.pregunta}" /><br />
		<br /> <input type="submit" value="A&ntilde;adir tema" />
	</form> 
	<a href="/JEE_ECP/faces/jsp/Home">Volver</a><br>
</body>
</html>