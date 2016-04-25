<%@ page import="org.springframework.web.util.UrlPathHelper"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

Formulario Cliente : ${opc}
<br>

<form:form commandName="cliente" action="save" method="POST">
	<form:label path="id">Id</form:label>
	<form:input path="id" />
	<br>
	<form:label path="apePaterno">Paterno:</form:label>
	<form:input path="apePaterno" />
	<br>
	<form:label path="apeMaterno">Materno:</form:label>
	<form:input path="apeMaterno" />
	<br>
	<form:label path="nombre">Nombre:</form:label>
	<form:input path="nombre" />
	<br>
	<form:label path="tipoDocumento">Tipo Documento:</form:label>
	<form:input path="tipoDocumento" />
	<br>
	<form:label path="nroDocumento">Nro Documento:</form:label>
	<form:input path="nroDocumento" />
	<br>
	<form:label path="telefono">Telefono:</form:label>
	<form:input path="telefono" />
	<br>
	<form:label path="estado">Estado:</form:label>
	<form:select path="estado">
		<form:option value="1">Activo</form:option>
		<form:option value="0">Inactivo</form:option>
	</form:select>
	<br>

	<input type="text" name="opc" id="opc" value="${opc}">
	<br>

	<button type="submit">Guardar</button>

</form:form>