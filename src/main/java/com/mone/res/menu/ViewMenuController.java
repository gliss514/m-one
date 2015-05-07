package com.mone.res.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mone.res.menu.model.Menu;
import com.mone.res.menu.model.MenuConstant;
import com.mone.res.menu.model.MenuService;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/viewMenu")
@Controller
public class ViewMenuController {
	@Autowired
	private MenuService menuService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(@ModelAttribute("menu") Menu menu, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("menu/viewMenu");
		modelView.addObject("menuCategory", menuService.getMenuCategory());

		menu.setCategory(MenuConstant.MAIN);
		modelView.addObject("mainResult", menuService.findByCodeLikeAndNameLikeAndCategoryLike(menu));

		menu.setCategory(MenuConstant.APPETIZER);
		modelView.addObject("appResult", menuService.findByCodeLikeAndNameLikeAndCategoryLike(menu));

		menu.setCategory(MenuConstant.BEVERAGE);
		modelView.addObject("bevResult", menuService.findByCodeLikeAndNameLikeAndCategoryLike(menu));

		menu.setCategory(MenuConstant.DESSERTS);
		modelView.addObject("desResult", menuService.findByCodeLikeAndNameLikeAndCategoryLike(menu));

		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView execute(@ModelAttribute("menu") Menu menu, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("menu/viewMenu");
		modelView.addObject("menuCategory", menuService.getMenuCategory());
		modelView.addObject("results", menuService.findByCodeLikeAndNameLikeAndCategoryLike(menu));
		return modelView;
	}
}