package com.service.category.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
   
	private String name;
	private List<Category> childs;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Category> getChilds() {
		if(childs==null) {
			childs = new ArrayList<Category>();
		}
		return childs;
	}
	public void setChilds(List<Category> childs) {
		this.childs = childs;
	}
		
}
