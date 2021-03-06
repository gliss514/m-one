<%@ attribute name="name" required="true" type="java.lang.String"%>
<%@ attribute name="items" required="true" type="java.util.Map" rtexprvalue="true"%>
<%@ attribute name="label" required="false" type="java.lang.String"%>
<%@ attribute name="mandatory" required="false" type="java.lang.String"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="gtag" %>

<div class="form-group">
	<gtag:label label="${label}" mandatory="${mandatory}" ></gtag:label>
	<div class="col-md-8 col-sm-pad">
		<form:select class="duallist form-control" path="${name}" id="${name}" items="${items}" />
	</div>
</div>