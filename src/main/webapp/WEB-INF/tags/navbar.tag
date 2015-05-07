<%@ attribute name="title" required="true" type="java.lang.String"%>
<%@ attribute name="items" required="true" type="java.util.List"
	rtexprvalue="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="gtag" tagdir="/WEB-INF/tags"%>

<nav class="navbar navbar-default">
	<div class="navbar-header">
		<a href="#" class="navbar-brand glyphicon glyphicon-home" href="#"
			onclick="load('index.g');"></a>
	</div>
	<ul class="nav navbar-nav">
		<c:forEach var="entry" items="${items}">
			<c:if test="${empty entry.childs}">
				<c:if test="${!empty entry.uri}">
					<li><a href="#" onclick="load('${entry.uri}')"><spring:message
								code="${entry.label}" text="${entry.label}" /></a></li>
				</c:if>
				<c:if test="${!empty entry.href}">
					<li><a href="${entry.href}"><spring:message
								code="${entry.label}" text="${entry.label}" /></a></li>
				</c:if>
			</c:if>
			<c:if test="${!empty entry.childs}">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><spring:message code="${entry.label}"
							text="${entry.label}" /><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<c:forEach var="childs" items="${entry.childs}">
							<c:if test="${!empty childs.uri}">
								<li><a onclick="load('${childs.uri}')"><spring:message
											code="${childs.label}" text="${childs.label}" /></a></li>
							</c:if>
							<c:if test="${!empty childs.href}">
								<li><a href="${childs.href}"><spring:message
											code="${childs.label}" text="${childs.label}" /></a></li>
							</c:if>
						</c:forEach>
					</ul></li>
			</c:if>
		</c:forEach>
	</ul>
	<div class="right-align pull-right">
		<button class="btn btn-default navbar-btn btn-sm" data-toggle="modal"
			data-target="#myModal">
			<span class="glyphicon glyphicon-user"></span>
		</button>
	</div>
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">User Settings</h4>
				</div>
				<div class="modal-body list-group">
					<a href="index.g" class="list-group-item">Logout</a>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
</nav>