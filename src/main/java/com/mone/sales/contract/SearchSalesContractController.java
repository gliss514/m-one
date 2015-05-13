package com.mone.sales.contract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mone.sales.contract.model.SalesContract;
import com.mone.sales.contract.model.SalesContractService;

@RequestMapping(value = "/searchSalesContract")
@Controller
public class SearchSalesContractController {

	@Autowired
	private SalesContractService salesContractService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(
			@ModelAttribute("salesContract") SalesContract salesContract,
			HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView(
				"contract/searchSalesContract");
		Iterable<SalesContract> salesContractIter = salesContractService
				.findAll();
		List<SalesContract> contractList = new ArrayList<>();
		for (SalesContract contract : salesContractIter) {
			contract.setDaysRemaining(getDaysRemaining(contract.getDateTo()));
			contract.setMonthsRemaining(getMonthsRemaining(contract.getDateTo()));
			contractList.add(contract);
		}
		Collections.sort(contractList, Collections.reverseOrder());
		modelView.addObject("results", contractList);
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView execute(
			@ModelAttribute("salesContract") SalesContract salesContract,
			HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView(
				"contract/searchSalesContract");
		return modelView;
	}

	private String getDaysRemaining(Date dateTo) {
		long days = 0;
		if (null != dateTo) {
			long diff = dateTo.getTime() - new Date().getTime();
			days = diff / 1000 / 60 / 60 / 24;
		}
		return String.valueOf(days);
	}

	private String getMonthsRemaining(Date dateTo) {
		long mths = 0;
		if (null != dateTo) {
			long diff = dateTo.getTime() - new Date().getTime();
			mths = diff / 1000 / 60 / 60 / 24 / 30;
		}
		return String.valueOf(mths);
	}
}
