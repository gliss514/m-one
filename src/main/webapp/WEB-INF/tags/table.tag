<%@ attribute name="id" required="false" type="java.lang.String"%>
<%@ attribute name="newUrl" required="false" type="java.lang.String"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="gtag"%>

<button type="button" onclick="load('${newUrl}');" class="btn btn-sm btn-default">
	<span class="glyphicon glyphicon-plus"></span>
</button>
<br />
<table class="table table-bordered" id="${id}">
	<jsp:doBody />
</table>