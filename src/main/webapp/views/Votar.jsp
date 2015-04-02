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
	<c:if test="${not empty votarBean.mensaje}">
	<h2>${votarBean.mensaje}</h2>
	</c:if>
	<form method="POST" action="/JEE_ECP/faces/jsp/Votar">
		<c:choose>
		<c:when test="${not empty votarBean.tema}">
			<label for="tema">Nombre del tema: </label>
			<input id="tema" name="tema" type="text" value="${votarBean.tema.nombre_tema}" readonly/><br />
			<input id="id_tema" name="id_tema" type="hidden" value="${votarBean.tema.id}" />
			<label for="pregunta">Pregunta: </label>
			<input id="pregunta" name="pregunta" type="text" value="${votarBean.tema.pregunta}" readonly/><br />
			<p>
				Nivel Estudios: <select name="nivel_estudios">
					<c:forEach var="nivel_estudio" items="${votarBean.nivelEstudios}">
						<option value="${nivel_estudio}">${nivel_estudio}</option>
					</c:forEach>
				</select>
			</p><br>
			
			<p>
				Valoraci&oacute;n: <select name="valoracion">
					<c:forEach begin="0" end="10" varStatus="loop">
						<option value="${loop.current}">${loop.current}</option>
					</c:forEach>
				</select>
			</p><br>
			<br /> <input type="submit" value="Enviar Voto" />
		</c:when>
		<c:when test="${votarBean.temas.size() == 0}">
			<h2>No hay ning&uacute;n tema para votar</h2>
		</c:when>
		<c:otherwise>
		<p>
				Temas: <select name="id_tema">
					<c:forEach var="tema" items="${votarBean.temas}">
						<option value="${tema.id}">${tema.nombre_tema}</option>
					</c:forEach>
				</select>
			</p>
			<br /> <input type="submit" value="SeleccionarTema" />
		</c:otherwise>
		</c:choose>
	</form>
	<br> 
	<a href="/JEE_ECP/faces/Home.jsp">Volver</a><br>
	
</body>
</html>