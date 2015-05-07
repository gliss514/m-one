<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="gtag"%>

<gtag:container>
	<gtag:form modelAttribute="customer" caption="gres.title.search.customer">
		<gtag:table id="customer" newUrl="createCustomer.g">
			<tr>
				<th>Code</th>
				<th>Company Name</th>
				<th>Name</th>
				<th>Type</th>
				<th>Action</th>
			</tr>
			<c:forEach var="customer" items="${results}">
				<tr>
					<td>${customer.code}</td>
					<td>${customer.companyName}</td>
					<td>${customer.name}</td>
					<td>${customer.type}</td>
					<td>
						<gtag:action icon="pencil" tooltip="tooltip.update" url="updateCustomer.g?id=${customer.id}"> </gtag:action>
						<gtag:action icon="trash" tooltip="tooltip.delete" url="deleteCustomer.g?id=${customer.id}"></gtag:action>
					</td>
				</tr>
			</c:forEach>
		</gtag:table>
	</gtag:form>
</gtag:container>