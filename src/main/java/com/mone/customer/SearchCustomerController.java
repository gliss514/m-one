package com.mone.customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mone.customer.model.Customer;
import com.mone.customer.model.CustomerService;

@RequestMapping(value = "/searchCustomer")
@Controller
public class SearchCustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(@ModelAttribute("customer") Customer customer,
			HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("customer/searchCustomer");

		List<Customer> consumer = new ArrayList<Customer>();
		List<Customer> sme = new ArrayList<Customer>();

		Iterable<Customer> custIter = customerService.findAll();
		
		Iterator iter = custIter.iterator();
		while(iter.hasNext()){
			Customer cust = (Customer) iter.next();
			if(cust.getType().equals("SME")){
				sme.add(cust);
			}else{
				consumer.add(cust);
			}
		}

		modelView.addObject("consumerList", consumer);
		modelView.addObject("smeList", sme);
		return modelView;
	}

	// @RequestMapping(method = RequestMethod.POST)
	// public ModelAndView execute(@ModelAttribute("menu") Menu menu,
	// HttpServletRequest req) {
	// ModelAndView modelView = new ModelAndView("customer/searchCustomer");
	// return modelView;
	// }
}
