<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

Listado de Sucursales

<br>
<a href="sucursales/registro">+ Sucursal</a>
<br>
<display:table name="${lista}" id="item" class="table">
	<display:column title="Codigo" property="id" />
	<display:column title="Razon Social" property="razonSocial" />
	<display:column title="RUC" property="ruc" />
	<display:column title="Direccion" property="direccion" />
	<display:column title="Telefono" property="nroTelefono" />
	<display:column title="Estado" property="estado" />
	<display:column title="OPC">
		<a href="sucursales/edit?id_=${item.id}">Modificar</a>
		<a href="sucursales/delete?id_=${item.id}">Eliminar</a>
	</display:column>

</display:table>