<%@ attribute name="label" required="true" type="java.lang.String"%>
<%@ attribute name="name" required="true" type="java.lang.String"%>
<%@ attribute name="mandatory" required="false" type="java.lang.String"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="gtag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="form-group">
	<gtag:label label="${label}" mandatory="${mandatory}" ></gtag:label>
	<div class="col-md-8 col-sm-pad">
		<div class="input-group">
			<form:input path="${name}" id="${name}" class="datepicker form-control" placeholder="dd/MM/yyyy"/>
			<form:errors path="${name}" cssClass="error" />
		</div>
	</div>
</div>