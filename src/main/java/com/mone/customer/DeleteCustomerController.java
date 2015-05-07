package com.mone.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mone.core.data.WebConstant;
import com.mone.customer.model.CustomerService;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/deleteCustomer")
@Controller
public class DeleteCustomerController {

	private static final String REDIRECT_SEARCH_PAGE = "redirect:searchCustomer.com.mone.g";

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public String post(HttpServletRequest req) {
		String id = req.getParameter(WebConstant.OBJID);
		if (id != null) {
			customerService.delete(id);
		}
		return REDIRECT_SEARCH_PAGE;
	}
	
}
