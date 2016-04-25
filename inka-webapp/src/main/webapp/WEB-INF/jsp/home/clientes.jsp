<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

Listado de Clientes

<br>
<a href="clientes/registro">+ Cliente</a>
<br>
<display:table name="${lista}" id="item" class="table">
	<display:column title="Codigo" property="id" />
	<display:column title="Paterno" property="apePaterno" />
	<display:column title="Materno" property="apeMaterno" />
	<display:column title="Nombre" property="nombre" />
	<display:column title="Estado" property="estado" />
	<display:column title="OPC">
		<a href="clientes/edit?id_=${item.id}">Modificar</a>
		<a href="clientes/delete?id_=${item.id}">Eliminar</a>
	</display:column>

</display:table>