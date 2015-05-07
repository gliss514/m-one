package com.mone.res.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mone.core.data.WebConstant;
import com.mone.res.menu.model.MenuService;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/deleteMenu")
@Controller
public class DeleteMenuController {

	private static final String REDIRECT_SEARCH_PAGE = "redirect:viewMenu.com.mone.g";

	@Autowired
	private MenuService menuService;

	@RequestMapping(method = RequestMethod.GET)
	public String post(HttpServletRequest req) {
		String menuId = req.getParameter(WebConstant.OBJID);
		if (menuId != null) {
			menuService.delete(menuId);
		}
		return REDIRECT_SEARCH_PAGE;
	}
}
