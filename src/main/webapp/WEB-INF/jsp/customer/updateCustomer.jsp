<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="gtag" tagdir="/WEB-INF/tags"%>

<html>
<body>
	<gtag:container>
		<gtag:form modelAttribute="customer" caption="New Customer">
			<gtag:textinput name="companyName" label="label.companyName" mandatory="yes" placeholder="Company Name"></gtag:textinput>
			<gtag:textinput name="name" label="label.name" mandatory="yes" placeholder="Name"></gtag:textinput>
			<gtag:textinput name="code" label="label.code" mandatory="yes" placeholder="Code"></gtag:textinput>
			<gtag:select name="type" label="label.type" mandatory="yes" items="${typeList}"></gtag:select>
			<gtag:textinput name="address" label="label.address" mandatory="yes" placeholder="Address"></gtag:textinput>
			<gtag:textinput name="contactNo" label="label.contactNo" mandatory="yes" placeholder="Contact No."></gtag:textinput>
			<gtag:textinput name="emailAddress" label="label.emailAddress" mandatory="yes" placeholder="Email Address"></gtag:textinput>
			<gtag:textinput name="salesPerson" label="label.salesPerson" mandatory="yes" placeholder="Address"></gtag:textinput>
			<gtag:buttoncontainer>
				<gtag:submit/>
				<gtag:button href="searchCustomer.g" label="label.cancel"/>
			</gtag:buttoncontainer>
		</gtag:form>
	</gtag:container>
</body>
</html>