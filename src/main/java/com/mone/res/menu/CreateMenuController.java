package com.mone.res.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mone.core.data.WebConstant;
import com.mone.res.menu.model.Menu;
import com.mone.res.menu.model.MenuService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequestMapping(value = "/createMenu")
@Controller
public class CreateMenuController {
	@Autowired
	private MenuService menuService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(@ModelAttribute("menu") Menu menu, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("menu/createMenu");
		modelView.addObject("menuCategory", menuService.getMenuCategory());
		String selectedCat = req.getParameter(WebConstant.CATEGORY);
		modelView.addObject("images", menuService.getMenuImageByCategory(selectedCat));
		modelView.addObject("title", selectedCat);
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView post(@Valid @ModelAttribute("menu") Menu menu, BindingResult result) {
		String page = "menu/createMenu";
		if (!result.hasErrors()) {
			page = "redirect:viewMenu.com.mone.g";
			menuService.save(menu);
		} else {
			System.out.println(result.getAllErrors().get(0).getDefaultMessage());
		}
		ModelAndView model = new ModelAndView(page);
		model.addObject("menuCategory", menuService.getMenuCategory());
		return model;
	}
}
