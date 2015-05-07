<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="gtag" tagdir="/WEB-INF/tags"%>

<html>
<body>
	<div class="glass container">
		<gtag:form modelAttribute="menu" caption="${title}">
			<gtag:textinput name="name" label="label.name" mandatory="yes" placeholder="Name"></gtag:textinput>
			<gtag:textinput name="code" label="label.code" mandatory="yes" placeholder="Code"></gtag:textinput>
			<gtag:numberinput name="price" label="gres.label.price" mandatory="yes"></gtag:numberinput>
			<gtag:imagepicker items="${images}" name="image"></gtag:imagepicker>
			<gtag:buttoncontainer>
				<gtag:submit/>
				<gtag:button href="viewMenu.g" label="label.cancel"/>
			</gtag:buttoncontainer>
		</gtag:form>
	</div>
</body>
</html>