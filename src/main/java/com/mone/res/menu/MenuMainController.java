package com.mone.res.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mone.res.menu.model.Menu;
import com.mone.res.menu.model.MenuService;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/menuMain")
@Controller
public class MenuMainController {
	@Autowired
	private MenuService menuService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(@ModelAttribute("menu") Menu menu, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("menu/menuMain");
		// modelView.addObject("list", results);
		return modelView;
	}
}
