<%@ attribute name="id" required="false" type="java.lang.String"%>
<%@ attribute name="modelAttribute" required="true" type="java.lang.String"%>
<%@ attribute name="caption" required="false" type="java.lang.String"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h3>
	<spring:message code="${caption}" text="${caption}" />
</h3>
<hr>
<form:form id="${id}" modelAttribute="${modelAttribute}" class="form-horizontal">
	<jsp:doBody />
	<form:hidden path="version" />
</form:form>
