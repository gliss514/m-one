<%@ attribute name="value" required="false" type="java.lang.String" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:if test="${not empty value}">
	<spring:message code="${value}" var="submitText"/>
</c:if>

<c:if test="${empty value}">
	<spring:message code="label.submit" var="submitText"/>
</c:if>

<input type="submit" class="btn btn-default" value="${submitText}" />