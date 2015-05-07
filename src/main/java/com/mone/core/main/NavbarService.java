package com.mone.core.main;

import org.springframework.stereotype.Service;
import com.mone.core.main.model.Navbar;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavbarService {

	// Get Navbar Menu
	public List<Navbar> getResItems() {
		List<Navbar> contents = new ArrayList<Navbar>();

		// Menu
		contents.add(createNavbar("gres.navbar.customer.master", "searchCustomer.com.mone.g"));
		contents.add(createNavbar("gres.navbar.sales.contract", "searchSalesContract.com.mone.g"));

		// Order
		 /*
		List<Navbar> makeOrder = new ArrayList<Navbar>();
		makeOrder.add(createNavbar("gres.navbar.dine-in", "order.com.mone.g"));
		makeOrder.add(createNavbar("gres.navbar.order.online", "orderOnline.com.mone.g"));
		contents.add(createNavbar("gres.navbar.make.order", "#", makeOrder));
		*/
		
		/*
		// Admin
		List<Navbar> adminPanel = new ArrayList<Navbar>();
		adminPanel.add(createNavbar("gres.title.manage.menu", "viewMenu.com.mone.g"));
		adminPanel.add(createNavbar("gres.title.manage.menu.image", "manageImages.com.mone.g"));
		contents.add(createNavbar("navbar.admin", "#", adminPanel));
		 */
		
		// Themes
		// List<Navbar> themes = new ArrayList<Navbar>();
		// themes.add(createHrefNavbar("theme.default", "?theme=default"));
		// themes.add(createHrefNavbar("theme.lumen", "?theme=lumen-ui"));
		// themes.add(createHrefNavbar("theme.yeti", "?theme=yeti-ui"));
		// themes.add(createHrefNavbar("theme.flatly", "?theme=flatly-ui"));
		// themes.add(createHrefNavbar("theme.cerulean", "?theme=cerulean-ui"));
		// contents.add(createNavbar("navbar.themes", "#", themes));

		return contents;
	}

	private Navbar createNavbar(String label, String link) {
		return new Navbar(label, link, null, null);
	}

	private Navbar createNavbar(String label, String link, List<Navbar> childs) {
		return new Navbar(label, link, childs, null);
	}

	private Navbar createHrefNavbar(String label, String link) {
		return new Navbar(label, null, null, link);
	}
}
