package com.mone.res.menu.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mone.core.data.ProjGRepository;
import com.mone.core.data.ProjGService;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuService extends ProjGService<Menu> {

	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private MenuRepository menuRepository;

	public Map<String, String> getMenuCategory() {
		Map<String, String> menuDataSource = new HashMap<String, String>();
		menuDataSource.put(null, "------- Please Select -------");
		menuDataSource.put(MenuConstant.APPETIZER, "Appetizer");
		menuDataSource.put(MenuConstant.BEVERAGE, "Beverage");
		menuDataSource.put(MenuConstant.DESSERTS, "Desserts");
		menuDataSource.put(MenuConstant.MAIN, "Main");
		return menuDataSource;
	}

	public Map<String, String> getMenuImageByCategory(String category) {
		if (StringUtils.isBlank(category)) category = "MAIN";
		Map<String, String> menuImages = new HashMap<String, String>();
		String path = servletContext.getRealPath("projg/images/" + category);
		String folderName = path == null ? "" : path.trim();
		File file = new File(folderName);
		if (file.listFiles() != null) {
			for (File f : file.listFiles()) {
				if (f.getName().endsWith("jpg") || f.getName().endsWith("png"))
					menuImages.put("projg/images/" + category + "/" + f.getName(), f.getName());
			}
		}
		return menuImages;
	}

	@Override
	protected ProjGRepository<Menu> getRepository() {
		return menuRepository;
	}

	public List<Menu> findByCodeLikeAndNameLikeAndCategoryLike(Menu criteria) {
		String code = StringUtils.isEmpty(criteria.getCode()) ? "" : criteria.getCode();
		String name = StringUtils.isEmpty(criteria.getName()) ? "" : criteria.getName();
		String category = StringUtils.isEmpty(criteria.getCategory()) ? "" : criteria.getCategory();
		return menuRepository.findByCodeLikeAndNameLikeAndCategoryLike(code, name, category);
	}
}
