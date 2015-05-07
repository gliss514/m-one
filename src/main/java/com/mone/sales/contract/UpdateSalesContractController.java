package com.mone.sales.contract;

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
import com.mone.sales.contract.model.SalesContract;
import com.mone.sales.contract.model.SalesContractService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequestMapping(value = "/updateSalesContract")
@Controller
public class UpdateSalesContractController {
	
	@Autowired
	private SalesContractService salesContractService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(HttpServletRequest req, @ModelAttribute("salesContract") SalesContract salesContract) {
		ModelAndView modelView = new ModelAndView("contract/updateSalesContract");
		String id = (String) req.getParameter(WebConstant.OBJID);
		SalesContract prevContract = salesContractService.findOne(id);
		prevContract.setCustomerCode(prevContract.getCustomer().getCode());
		initDropdowns(modelView);
		modelView.addObject(prevContract);
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView post(@Valid @ModelAttribute("salesContract") SalesContract salesContract, BindingResult result) {
		String page = "contract/updateSalesContract";
		if (!result.hasErrors()) {
			SalesContract prevContract = salesContractService.findOne(salesContract.getId());
			BeanUtils.copyProperties(salesContract, prevContract);
			Customer customer = customerService.findByCode(salesContract.getCustomerCode());
			salesContract.setCustomer(customer);
			page = "redirect:searchSalesContract.com.mone.g";
			salesContractService.save(salesContract);
		} else {
			System.out.println(result.getAllErrors().get(0).getDefaultMessage());
		}
		ModelAndView model = new ModelAndView(page);
		initDropdowns(model);
		return model;
	}
	
	private void initDropdowns(ModelAndView model){
		model.addObject("customerList", customerService.getCustomerList());
	}
	
}
