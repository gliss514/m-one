package com.mone.core.main.model;

import org.springframework.data.mongodb.core.mapping.Document;
import com.mone.core.data.BaseObject;

import java.util.List;

@Document
public class Navbar extends BaseObject {
	
	private static final long serialVersionUID = 3582769539927135956L;

	private String label;

	private String uri;

	private String href;

	private List<Navbar> childs;

	public Navbar() {
	}

	public Navbar(String label, String uri, List<Navbar> childs, String href) {
		super();
		this.label = label;
		this.uri = uri;
		this.childs = childs;
		this.href = href;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<Navbar> getChilds() {
		return childs;
	}

	public void setChilds(List<Navbar> childs) {
		this.childs = childs;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
