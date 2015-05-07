<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="gtag" tagdir="/WEB-INF/tags"%>

<html>
<body>
	<div class="glass container">
		<gtag:form modelAttribute="menu" caption="gres.title.manage.menu">
			<gtag:menutable caption="Main" cat="MAIN" items="${mainResult}"></gtag:menutable>
			<gtag:menutable caption="Appetizer" cat="APPETIZER" items="${appResult}"></gtag:menutable>
			<gtag:menutable caption="Beverage" cat="BEVERAGE" items="${bevResult}"></gtag:menutable>
			<gtag:menutable caption="Desserts" cat="DESSERTS" items="${desResult}"></gtag:menutable>
		</gtag:form>
	</div>
</body>
</html>