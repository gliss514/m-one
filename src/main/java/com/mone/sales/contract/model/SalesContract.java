package com.mone.sales.contract.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.format.annotation.DateTimeFormat;
import com.mone.core.data.BaseObject;
import com.mone.customer.model.Customer;

import java.util.Date;

public class SalesContract extends BaseObject {

	private static final long serialVersionUID = -1720556050639569387L;

	private String salesNo;

	@DBRef
	private Customer customer;

	private String customerCode;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateFrom;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateTo;

	private String monthsRemaining;
	
	private String daysRemaining;

	private String relatedDocuments;

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getSalesNo() {
		return salesNo;
	}

	public void setSalesNo(String salesNo) {
		this.salesNo = salesNo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getDaysRemaining() {
		return daysRemaining;
	}

	public void setDaysRemaining(String daysRemaining) {
		this.daysRemaining = daysRemaining;
	}

	public String getMonthsRemaining() {
		return monthsRemaining;
	}

	public void setMonthsRemaining(String monthsRemaining) {
		this.monthsRemaining = monthsRemaining;
	}

	public String getRelatedDocuments() {
		return relatedDocuments;
	}

	public void setRelatedDocuments(String relatedDocuments) {
		this.relatedDocuments = relatedDocuments;
	}
}
