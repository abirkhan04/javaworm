package com.service.category.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.service.category.model.Category;

public class PayloadParser {

	private static Log Logger = LogFactory.getLog(PayloadParser.class);

	public static List<Category> ParseJSONPayload(String JsonPayload) {
		List<Category> categoryList = new ArrayList<Category>();
		JsonParser parser = new JsonParser();
		JsonElement jsonElement = parser.parse(JsonPayload);
		if (((JsonElement) jsonElement).isJsonArray()) {
			JsonArray details = ((JsonElement) jsonElement).getAsJsonArray();
			Logger.info("The total number of categories: " + details.size());
			for (int i = 0; i < details.size(); i++) {
				Category category = new Category();
				JsonObject object = details.get(i).getAsJsonObject();
				category.setName(object.get("category").toString());
				JsonArray childArray = object.get("childs").getAsJsonArray();
				List<Category> childCategoryList = new ArrayList<Category>();
				childArray.forEach(element -> {
					JsonObject childObject = element.getAsJsonObject();
					Category childCateogry = new Category();
					childCateogry.setName(childObject.get("category").toString());
					childCategoryList.add(childCateogry);
					category.setChilds(childCategoryList);
				});
				categoryList.add(category);
			}
		}
		return categoryList;
	}
}
