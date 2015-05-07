<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="gtag" tagdir="/WEB-INF/tags"%>

<html>
<body>
	<div class="glass container">
		<gtag:form modelAttribute="menu">
			<div class="panel-group" id="accordion">
				<gtag:accordion id="#appetizer" parId="#accordion" contentId="appetizer" caption="gres.label.appetizer">
					<div id="appetizer-container"></div>
				</gtag:accordion>
				<gtag:accordion id="#main" parId="#accordion" contentId="main" caption="gres.label.main">
					<div id="main-container"></div>
				</gtag:accordion>
				<gtag:accordion id="#sides" parId="#accordion" contentId="sides" caption="gres.label.sides">
					<div id="sides-container"></div>
				</gtag:accordion>
				<gtag:accordion id="#desserts" parId="#accordion" contentId="desserts" caption="gres.label.desserts">
					<div id="desserts-container"></div>
				</gtag:accordion>
				<gtag:accordion id="#beverage" parId="#accordion" contentId="beverage" caption="gres.label.beverage">
					<div id="beverage-container"></div>
				</gtag:accordion>
			</div>
		</gtag:form>
	</div>
</body>
<script type="text/javascript">
	$('#appetizer-container').load('menuAppetizer.g');
	$('#main-container').load('menuMain.g');
	$('#sides-container').load('menuSides.g');
	$('#desserts-container').load('menuDesserts.g');
	$('#beverage-container').load('menuBeverage.g');
</script>
</html>