<%@ attribute name="name" required="true" type="java.lang.String"%>
<%@ attribute name="label" required="false" type="java.lang.String"%>
<%@ attribute name="mandatory" required="false" type="java.lang.String"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="gtag"%>

<div class="form-group">
	<gtag:label label="${label}" mandatory="${mandatory}"></gtag:label>
	<div class="col-md-8 col-sm-pad">
		<form:input type="text" path="${name}" id="touchspin" class="touchspin"/>
	</div>
</div>