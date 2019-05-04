package com.service.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.category.categoryservice.CategoryService;
import com.service.category.model.Category;
import com.service.category.util.PayloadParser;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.*;

@RestController
@RequestMapping(value = "category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	private static Log Logger = LogFactory.getLog(CategoryController.class);

	@PostMapping(value = "insertcategories")
	public @ResponseBody String insertCategories(@RequestBody String CategoryJSON) throws IOException {
		Logger.info("Requested Payload: " + CategoryJSON);
		List<Category> categoryList = PayloadParser.ParseJSONPayload(CategoryJSON);
	    return categoryService.SaveCategories(categoryList);
	}
}
