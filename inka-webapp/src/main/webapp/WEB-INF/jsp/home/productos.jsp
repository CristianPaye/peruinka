<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

Listado de Productos

<br>
<a href="productos/registro">+ Producto</a>
<br>
<display:table name="${lista}" id="item" class="table">
	<display:column title="Codigo" property="id" />
	<display:column title="Nombre" property="nombre" />
	<display:column title="Precio" property="precio" />
	<display:column title="Atributo" property="atributo" />
	<display:column title="Estado" property="estado" />
	<display:column title="OPC">
		<a href="productos/edit?id_=${item.id}">Modificar</a>
		<a href="productos/delete?id_=${item.id}">Eliminar</a>
	</display:column>

</display:table>