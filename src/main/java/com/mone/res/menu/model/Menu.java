package com.mone.res.menu.model;

import org.hibernate.validator.constraints.NotEmpty;
import com.mone.core.data.BaseObject;

import javax.validation.constraints.NotNull;

public class Menu extends BaseObject {

	private static final long serialVersionUID = -2751330483335516877L;

	@NotEmpty
	private String name;

	@NotEmpty
	private String code;

	private String image;

	@NotEmpty
	private String category;

	@NotNull
	private Double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
