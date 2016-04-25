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

Formulario Producto : ${opc}
<br>

<form:form commandName="producto" action="save" method="POST">
	<form:label path="id">Id</form:label>
	<form:input path="id" id="id" />
	<br>
	<form:label path="nombre">Nombre:</form:label>
	<form:input path="nombre" />
	<br>
	<form:label path="precio">Precio:</form:label>
	<form:input path="precio" />
	<br>
	<form:label path="atributo">Atributo:</form:label>
	<form:input path="atributo" />
	<br>

	<form:label path="tipoProductoId">Tipo Producto:</form:label>
	<form:select path="tipoProductoId">
		<form:option value="0">Habitacion</form:option>
		<form:option value="1">Servicio Lavanderia</form:option>
		<form:option value="2">Comida</form:option>
		<form:option value="3">Bazar</form:option>
		<form:option value="4">Bar</form:option>
	</form:select>
	<br>

	<form:label path="sucursalId">Sucursal</form:label>
	<form:select path="sucursalId">
		<form:options items="${sucursales}" itemValue="id"
			itemLabel="razonSocial" />
	</form:select>
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