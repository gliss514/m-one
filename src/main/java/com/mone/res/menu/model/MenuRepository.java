package com.mone.res.menu.model;

import org.springframework.stereotype.Repository;
import com.mone.core.data.ProjGRepository;

import java.util.List;


public interface MenuRepository extends ProjGRepository<Menu> {
	List<Menu> findByCodeLikeAndNameLikeAndCategoryLike(String code, String name, String category);
}
