package com.mone.res.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.mone.res.menu.model.ImageManager;
import com.mone.res.menu.model.MenuService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RequestMapping(value = "/manageImages")
@Controller
public class ManageImagesController {

	@Autowired
	private ServletContext servletContext;

	@Autowired
	private MenuService menuService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(@ModelAttribute("imageManager") ImageManager imageManager, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("menu/manageImages");
		modelView.addObject("menuCategory", menuService.getMenuCategory());
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView execute(@ModelAttribute("imageManager") ImageManager imageManager, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("menu/manageImages");
		MultipartFile mf = imageManager.getFile();
		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			if (!StringUtils.isEmpty(imageManager.getCategory())) {
				String path = servletContext.getRealPath("projg/images/" + imageManager.getCategory());
				String folderName = path == null ? "" : path.trim();
				File file = new File(folderName + "/" + mf.getOriginalFilename());
				if (!file.exists()) {
					file.createNewFile();
				}

				inputStream = mf.getInputStream();
				outputStream = new FileOutputStream(file);

				System.out.println(file.getAbsolutePath());

				int read = 0;
				byte[] bytes = new byte[1024];

				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				outputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return modelView;
	}
}
