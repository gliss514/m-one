package com.mone.res.menu.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;
import com.mone.core.data.BaseObject;

@Document
public class ImageManager extends BaseObject {

	private static final long serialVersionUID = 7097914632459943249L;

	private String category;

	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
