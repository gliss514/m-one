<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="gtag"%>

<gtag:container>
	<gtag:form modelAttribute="salesContract" caption="gres.title.search.contract">
		<gtag:table id="salesContract" newUrl="createSalesContract.g">
			<tr>
				<th>Company Name</th>
				<th>Customer Name</th>
				<th>Total Lines</th>
				<th>Date From</th>
				<th>Date To</th>
				<th>Month(s) Remaining</th>
				<th>Day(s) Remaining</th>
				<th>Action</th>
			</tr>
			<c:forEach var="salesContract" items="${results}">
				<tr>
					<td>${salesContract.customer.companyName}</td>
					<td>${salesContract.customer.name}</td>
					<td>${salesContract.totalLines}</td>
					<td><fmt:formatDate value="${salesContract.dateFrom}" pattern="dd/MM/yyyy" /></td>
					<td><fmt:formatDate value="${salesContract.dateTo}" pattern="dd/MM/yyyy" /></td>
					<td>${salesContract.monthsRemaining}</td>
					<td>${salesContract.daysRemaining}</td>
					<td><gtag:action icon="pencil" tooltip="tooltip.update"
							url="updateSalesContract.g?id=${salesContract.id}"></gtag:action> &nbsp; <gtag:action
							icon="trash" tooltip="tooltip.delete"
							url="deleteSalesContract.g?id=${salesContract.id}"></gtag:action></td>
				</tr>
			</c:forEach>
		</gtag:table>
	</gtag:form>
</gtag:container>