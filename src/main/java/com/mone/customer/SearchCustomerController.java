package com.mone.customer;

import com.mone.customer.model.Customer;
import com.mone.customer.model.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/searchCustomer")
@Controller
public class SearchCustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(@ModelAttribute("customer") Customer customer, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("customer/searchCustomer");
		modelView.addObject("results", customerService.findAll());
		return modelView;
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	public ModelAndView execute(@ModelAttribute("menu") Menu menu, HttpServletRequest req) {
//		ModelAndView modelView = new ModelAndView("customer/searchCustomer");
//		return modelView;
//	}
}
