<%@ attribute name="label" required="true" type="java.lang.String"%>
<%@ attribute name="value" required="false" type="java.lang.String"%>
<%@ attribute name="mandatory" required="false" type="java.lang.String"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:if test="${mandatory == 'yes'}">
	<c:set var="mandatory" value="visible" />
</c:if>

<c:if test="${mandatory == 'no'}">
	<c:set var="mandatory" value="hidden" />
</c:if>

<c:if test="${empty mandatory}">
	<c:set var="mandatory" value="hidden" />
</c:if>

<c:if test="${!empty value}">
	<div class="form-group">

		<label class="col-md-2 control-label"><spring:message code="${label}" text="${label}" /></label>
		<div class="col-md-8 col-sm-pad">
			<label class="form-control"><spring:message code="${value}" text="${value}" /></label>
		</div>
	</div>
</c:if>

<c:if test="${empty value}">
	<label class="col-sm-2 control-label col-sm-pad"><spring:message code="${label}" text="${label}" /> <a style="font-size: 15px; color: red; visibility: ${mandatory};text-decoration: none;">*</a></label>
</c:if>