<%@ attribute name="cat" required="false" type="java.lang.String"%>
<%@ attribute name="items" required="true" type="java.util.List"%>
<%@ attribute name="caption" required="false" type="java.lang.String"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="gtag"%>

<button type="button" onclick="load('createMenu.g?category=${cat}');"
	class="btn btn-default"><span class="glyphicon glyphicon-plus"></span> ${caption} 
</button>
<br />
<br />
<table class="table table-bordered" id="${cat}" title="${caption}">
	<thead>
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Category</th>
			<th>Price</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="menu" items="${items}">
			<tr>
				<td>${menu.code}</td>
				<td>${menu.name}</td>
				<td>${menu.category}</td>
				<td>${menu.price}</td>
				<td>
					<gtag:action icon="pencil" tooltip="tooltip.update" url="updateMenu.g?category=${menu.category}&id=${menu.id}"></gtag:action>
					&nbsp;
					<gtag:action icon="trash" tooltip="tooltip.delete" url="deleteMenu.g?id=${menu.id}"></gtag:action>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<hr />
