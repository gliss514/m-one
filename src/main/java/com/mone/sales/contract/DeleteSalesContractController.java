package com.mone.sales.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mone.core.data.WebConstant;
import com.mone.sales.contract.model.SalesContractService;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/deleteSalesContract")
@Controller
public class DeleteSalesContractController {
	
	private static final String REDIRECT_SEARCH_PAGE = "redirect:searchSalesContract.com.mone.g";
	
	@Autowired
	private SalesContractService salesContractService;

	@RequestMapping(method = RequestMethod.GET)
	public String post(HttpServletRequest req) {
		String id = req.getParameter(WebConstant.OBJID);
		if (id != null) {
			salesContractService.delete(id);
		}
		return REDIRECT_SEARCH_PAGE;
	}

}
