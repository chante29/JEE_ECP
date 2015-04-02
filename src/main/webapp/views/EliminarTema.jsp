<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EliminarView</title>
</head>
<body>
	<h2>
		Vista de <b>Eliminar</b>
	</h2>
	<c:set var="eliminarTemaBean" scope="request" value="${EliminarTema}" />
	<c:if test="${not empty eliminarTemaBean.mensaje}">
	<h2>${eliminarTemaBean.mensaje}</h2>
	</c:if>
	<c:choose>
	
	<c:when test="${eliminarTemaBean.temas.size() == 0}">
		<h2>No hay ning&uacute;n tema para eliminar</h2>
	</c:when>
	<c:otherwise>
	<form method="POST" action="/JEE_ECP/faces/jsp/EliminarTema">
	  <c:choose>
			<c:when test="${not eliminarTemaBean.autorizado }">
				<label for="token">Introduce c&oacute;digo: </label>
				<input id="token" name="token" type="text" /><br />
				<br /> <input type="submit" value="Enviar Token" />
			</c:when>
			<c:otherwise>
			<div>${eliminarTemaBean.update()}</div>
				<p>
					Temas: <select name="tema">
						<c:forEach var="tema" items="${eliminarTemaBean.temas}">
							<option value="${tema.id}" >${tema.nombre_tema}</option>
						</c:forEach>
					</select>
				</p>
				<br /> <input type="submit" value="Eliminar tema" />
			</c:otherwise>
		</c:choose>
	</form> 
	</c:otherwise>
	</c:choose>
	<a href="/JEE_ECP/faces/Home.jsp">Volver</a><br>

</body>
</html>