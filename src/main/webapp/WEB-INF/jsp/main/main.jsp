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
		<gtag:navbar title="gres.navbar.title" items="${navbarItems}"/>
		<div id="workspace"></div>
	</body>
</gtag:scriptcss>
</html>