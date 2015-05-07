<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="gtag" tagdir="/WEB-INF/tags"%>

<html>
<body>
	<div class="glass container">
		<gtag:form modelAttribute="imageManager" caption="gres.title.manage.menu.image">
			<gtag:select items="${menuCategory}" name="category" label="gres.label.category"></gtag:select>
			<gtag:fileinput name="file" label="gres.label.image"></gtag:fileinput>
			<gtag:buttoncontainer>
				<gtag:submit/>
			</gtag:buttoncontainer>
		</gtag:form>
	</div>
</body>
</html>