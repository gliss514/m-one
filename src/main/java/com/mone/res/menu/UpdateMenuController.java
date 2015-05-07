package com.mone.res.menu;

import org.springframework.beans.BeanUtils;
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

@RequestMapping(value = "/updateMenu")
@Controller
public class UpdateMenuController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(HttpServletRequest req, @ModelAttribute("menu") Menu menu) {
		ModelAndView modelView = new ModelAndView("menu/updateMenu");
		String id = (String) req.getParameter(WebConstant.OBJID);
		String selectedCat = (String) req.getParameter(WebConstant.CATEGORY);
		Menu prevMenu = menuService.findOne(id);
		modelView.addObject("images", menuService.getMenuImageByCategory(selectedCat));
		modelView.addObject("title", selectedCat);
		modelView.addObject(prevMenu);
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView post(@Valid @ModelAttribute("menu") Menu menu, BindingResult result) {
		String page = "menu/updateMenu";
		if (!result.hasErrors()) {
			Menu prevMenu = menuService.findOne(menu.getId());
			BeanUtils.copyProperties(menu, prevMenu);
			page = "redirect:viewMenu.com.mone.g";
			menuService.save(prevMenu);
		} else {
			System.out.println(result.getAllErrors().get(0).getDefaultMessage());
		}
		ModelAndView model = new ModelAndView(page);
		model.addObject("menuCategory", menuService.getMenuCategory());
		return model;
	}
}
