package com.mone.sales.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mone.sales.contract.model.SalesContract;
import com.mone.sales.contract.model.SalesContractService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequestMapping(value = "/searchSalesContract")
@Controller
public class SearchSalesContractController {

	@Autowired
	private SalesContractService salesContractService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(@ModelAttribute("salesContract") SalesContract salesContract, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("contract/searchSalesContract");
		Iterable<SalesContract> salesContractIter = salesContractService.findAll();
		for (SalesContract contract : salesContractIter) {
			contract.setDaysRemaining(getDaysRemaining(contract.getDateTo()));
			contract.setMonthsRemaining(getMonthsRemaining(contract.getDateTo()));
		}
		modelView.addObject("results", salesContractIter);
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView execute(@ModelAttribute("salesContract") SalesContract salesContract, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("contract/searchSalesContract");
		return modelView;
	}
	
	private String getDaysRemaining(Date dateTo){
		long diff = dateTo.getTime() - new Date().getTime();
		long days = diff / 1000 / 60 / 60 / 24;
		return String.valueOf(days);
	}
	
	private String getMonthsRemaining(Date dateTo){
		long diff = dateTo.getTime() - new Date().getTime();
		long mths = diff / 1000 / 60 / 60 / 24 / 30;
		return String.valueOf(mths);
	}
}
