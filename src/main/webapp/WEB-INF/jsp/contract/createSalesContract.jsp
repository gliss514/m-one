<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="gtag" tagdir="/WEB-INF/tags"%>

<html>
<body>
	<gtag:container>
		<gtag:form modelAttribute="salesContract" caption="New Contract">
			<gtag:select name="customerCode" label="label.name" mandatory="yes" items="${customerList}"></gtag:select>
			<gtag:datepicker name="dateFrom" label="label.dateFrom" mandatory="yes"></gtag:datepicker>
			<gtag:datepicker name="dateTo" label="label.dateTo" mandatory="yes"></gtag:datepicker>
			<gtag:buttoncontainer>
				<gtag:submit/>
				<gtag:button href="searchSalesContract.g" label="label.cancel"/>
			</gtag:buttoncontainer>
		</gtag:form>
	</gtag:container>
</body>
</html>