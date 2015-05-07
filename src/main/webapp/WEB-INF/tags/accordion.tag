<%@ attribute name="id" required="true" type="java.lang.String"%>
<%@ attribute name="parId" required="true" type="java.lang.String"%>
<%@ attribute name="contentId" required="true" type="java.lang.String"%>
<%@ attribute name="caption" required="true" type="java.lang.String"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="panel panel-default">
	<div class="panel-heading">
		<h4 class="panel-title">
			<a data-toggle="collapse" data-parent="${parId}" href="${id}">
				<spring:message code="${caption}" text="${caption}"></spring:message>
			</a>
		</h4>
	</div>
	<div id="${contentId}" class="panel-collapse collapse">
		<jsp:doBody/>
	</div>
</div>