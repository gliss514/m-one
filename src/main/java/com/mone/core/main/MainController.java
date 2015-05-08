package com.mone.core.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mone.core.main.model.Navbar;
import com.mone.core.security.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

	@Autowired
	NavbarService navbarService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute("user") User user) {
		ModelAndView modelView = new ModelAndView("main/index");
		modelView.addObject("navbarItems", getNavbars());
		return modelView;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("main/main");
		modelView.addObject("navbarItems", getNavbars());
		return modelView;
	}
	
	private List<Navbar> getNavbars(){
		return navbarService.getResItems();
	}
}
