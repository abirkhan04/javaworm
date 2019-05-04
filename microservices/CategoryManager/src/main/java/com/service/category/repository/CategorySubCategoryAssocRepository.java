package com.service.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.category.pojo.CategorySubCategoryAssoc;

public interface CategorySubCategoryAssocRepository extends JpaRepository<CategorySubCategoryAssoc,Long>{
     
	
}
