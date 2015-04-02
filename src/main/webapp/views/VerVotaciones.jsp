<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VerVotacionesView</title>
</head>
<body>
<h2>
		Vista de <b>Ver Votaciones</b>
	</h2>
	<c:set var="verVotacionesBean" scope="request" value="${VerVotaciones}" />
	<div>${verVotacionesBean.update()}</div>
	<form method="POST" action="/JEE_ECP/faces/jsp/VerVotaciones">
	<p>
				Temas: <select name="id_tema" onchange="this.form.submit()">
				<c:if test="${ empty verVotacionesBean.tema}">
					<option value="default" selected></option>
				</c:if>
					<c:forEach var="tema" items="${verVotacionesBean.temas}">
						<c:choose>
							<c:when test="${not empty verVotacionesBean.tema && verVotacionesBean.tema.id == tema.id}">
								<option value="${tema.id}" selected>${tema.nombre_tema}</option>
							</c:when>
							<c:otherwise>
								<option value="${tema.id}" >${tema.nombre_tema}</option>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
				</select>
			</p>
	</form>
	<c:if test="${not empty verVotacionesBean.tema}">
	<br>
			<label for="numVotos">N&uacute;mero de votos: </label>
			<input id="numVotos"  type="text" value="${verVotacionesBean.numVotos}" readonly/><br />
			<br><br><br>
		<c:forEach var="nivel_estudio" items="${verVotacionesBean.niveles_estudios}">
			<c:if test="${verVotacionesBean.medias.containsKey(nivel_estudio)}">
				<label for="nivelEstudios">N&iacute;vel de estudios: </label>
				<input id="nivelEstudios"  type="text" value="${nivel_estudio}" readonly/><br />
				<label for="notaMedia">Nota media: </label>
				<input id="notaMedia"  type="text" value="${verVotacionesBean.medias.get(nivel_estudio)}" readonly/><br />
				<br><br>
			</c:if>
		
		</c:forEach>
		
			
	</c:if>
	<br> 
	<a href="/JEE_ECP/faces/Home.jsp">Volver</a><br>
	
</body>
</html>