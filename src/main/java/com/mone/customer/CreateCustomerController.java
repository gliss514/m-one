package com.mone.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mone.customer.model.Customer;
import com.mone.customer.model.CustomerService;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/createCustomer")
@Controller
public class CreateCustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(@ModelAttribute("customer") Customer customer,
			HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("customer/createCustomer");
		initDropdowns(modelView);
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView execute(@ModelAttribute("customer") Customer customer,
			BindingResult result, HttpServletRequest req) {
		String page = "menu/createCustomer";
		if (!result.hasErrors()) {
			page = "redirect:searchCustomer.com.mone.g";
			customerService.save((Customer)result.getTarget());
		} else {
			System.out.println(result.getAllErrors().get(0).getDefaultMessage());
		}
		ModelAndView model = new ModelAndView(page);
		initDropdowns(model);
		return model;
	}
	
	private void initDropdowns(ModelAndView model){
		model.addObject("typeList", customerService.getTypeList());
	}
}