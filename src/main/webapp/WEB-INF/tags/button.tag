<%@ attribute name="onclick" type="java.lang.String" %>
<%@ attribute name="href" required="true" type="java.lang.String" %>
<%@ attribute name="label" required="true" type="java.lang.String" %>
<%@ attribute name="btnType" type="java.lang.String" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:if test="${!empty btnType}">
	<c:set var="btnType" value="btn-${btnType}" />
</c:if>
<c:if test="${empty btnType}">
	<c:set var="btnType" value="btn btn-default" />
</c:if>


<c:if test="${empty onclick}">
		<form:button href="#" type="button" class="${btnType}" style="${width}" onclick="load('${href}')"><spring:message code="${label}" text="${label}" /></form:button>
</c:if>

<c:if test="${!empty onclick}">
		<form:button href="#" type="button" class="${btnType}" style="${width}" onclick="${onclick}"><spring:message code="${label}" text="${label}" /></form:button>
</c:if>

