package com.service.category.categoryservice;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.category.model.Category;
import com.service.category.pojo.CategorySubCategoryAssoc;
import com.service.category.pojo.DbCategory;
import com.service.category.pojo.SubCategory;
import com.service.category.repository.CategoryRepository;
import com.service.category.repository.CategorySubCategoryAssocRepository;
import com.service.category.repository.SubCategoryRepository;

@Service
public class CategoryService {
	
	
	private static Log Logger = LogFactory.getLog(CategoryService.class);
	
	@Autowired
	CategoryRepository<DbCategory> categoryRepository;
	
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Autowired
	CategorySubCategoryAssocRepository categorySubCategoryAssocRepository;
	
	public DbCategory SaveCategory(DbCategory category) {
		return categoryRepository.save(category);
	}
	
	
	public String SaveCategories(List<Category> categoryList){		
		for(int i=0;i<categoryList.size();i++) {
			Category category = categoryList.get(i);		
			DbCategory dbCategory = new DbCategory();			
			
			//Retrieving parent category
			dbCategory.setName(category.getName());			
			
			//saving parent category
			categoryRepository.save(dbCategory);
			Logger.info("Saved DBInstance: "+dbCategory.getId());
	
			List<Category> childCategoryList = category.getChilds();
			for(int j=0; j<childCategoryList.size();j++) {
				//Retrieving SubCategories
				Category childCategory =  childCategoryList.get(i);
                SubCategory subCategory  = new SubCategory();
                subCategory.setName(childCategory.getName());
                subCategoryRepository.save(subCategory);
                CategorySubCategoryAssoc categorySubCategoryAssoc = new CategorySubCategoryAssoc();
                categorySubCategoryAssoc.setCategoryId(dbCategory.getId());
                categorySubCategoryAssoc.setSubCategoryId(subCategory.getId());
                categorySubCategoryAssocRepository.save(categorySubCategoryAssoc);
			}				
		}		
		return "Categories are successfully Inserted to the database.";
	} 	
}