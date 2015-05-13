<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="gtag"%>

<gtag:container>
	<gtag:form modelAttribute="customer" caption="gres.title.search.customer">
		<gtag:table id="customer" newUrl="createCustomer.g">
			<tr>
				<th>Name</th>
				<th>Contact No.</th>
				<th>Company Name</th>
				<th>Sales Person</th>
				<th>Action</th>
			</tr>
			<c:forEach var="customer" items="${consumerList}">
				<tr>
					<td>${customer.name}</td>
					<td>${customer.contactNo}</td>
					<td>${customer.companyName}</td>
					<td>${customer.salesPerson}</td>
					<td>
						<gtag:action icon="pencil" tooltip="tooltip.update" url="updateCustomer.g?id=${customer.id}"> </gtag:action>
						<gtag:action icon="trash" tooltip="tooltip.delete" url="deleteCustomer.g?id=${customer.id}"></gtag:action>
					</td>
				</tr>
			</c:forEach>
		</gtag:table>
		
		<gtag:table id="customer" newUrl="createCustomer.g">
			<tr>
				<th>Company Name</th>
				<th>Name</th>
				<th>Contact No.</th>
				<th>Sales Person</th>
				<th>Action</th>
			</tr>
			<c:forEach var="customer" items="${smeList}">
				<tr>
					<td>${customer.companyName}</td>
					<td>${customer.name}</td>
					<td>${customer.contactNo}</td>
					<td>${customer.salesPerson}</td>
					<td>
						<gtag:action icon="pencil" tooltip="tooltip.update" url="updateCustomer.g?id=${customer.id}"> </gtag:action>
						<gtag:action icon="trash" tooltip="tooltip.delete" url="deleteCustomer.g?id=${customer.id}"></gtag:action>
					</td>
				</tr>
			</c:forEach>
		</gtag:table>
	</gtag:form>
</gtag:container>