package com.mone.customer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mone.core.data.WebConstant;
import com.mone.customer.model.Customer;
import com.mone.customer.model.CustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequestMapping(value = "/updateCustomer")
@Controller
public class UpdateCustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(HttpServletRequest req, @ModelAttribute("customer") Customer customer) {
		ModelAndView modelView = new ModelAndView("customer/updateCustomer");
		String id = (String) req.getParameter(WebConstant.OBJID);
		Customer prevCustomer = customerService.findOne(id);
		modelView.addObject(prevCustomer);
		initDropdowns(modelView);
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView post(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		String page = "customer/updateCustomer";
		if (!result.hasErrors()) {
			customer = (Customer) result.getTarget();
			Customer prevCustomer = customerService.findOne(customer.getId());
			BeanUtils.copyProperties(customer, prevCustomer);
			page = "redirect:searchCustomer.com.mone.g";
			customerService.save(customer);
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
