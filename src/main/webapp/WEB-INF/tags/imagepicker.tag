<%@ attribute name="name" required="true" type="java.lang.String"%>
<%@ attribute name="selected" required="false" type="java.lang.String"%>
<%@ attribute name="items" required="true" type="java.util.Map" rtexprvalue="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<select class="imagepicker" id="${name}" name="${name}">
	<c:forEach var="entry" items="${items}">
		<c:if test="${selected == entry.value}">
			<option data-img-src="${entry.key}" value="${entry.value}" selected="selected"></option>
		</c:if>
		<c:if test="${selected != entry.value}">
			<option data-img-src="${entry.key}" value="${entry.value}"></option>
		</c:if>
	</c:forEach>
</select>
