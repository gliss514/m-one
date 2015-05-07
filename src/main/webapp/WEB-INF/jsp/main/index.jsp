<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="gtag" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<gtag:scriptcss>
<body>
	<gtag:container>
		<gtag:form modelAttribute="user" caption="Sign In">
			<gtag:textinput name="username" label="label.username" mandatory="yes" placeholder="Username"></gtag:textinput>
			<gtag:password name="password" label="label.password" mandatory="yes" placeholder="Password"></gtag:password>
			<gtag:buttoncontainer>
				<gtag:submit/>
			</gtag:buttoncontainer>
		</gtag:form>
	</gtag:container>
</body>
</gtag:scriptcss>
</html>