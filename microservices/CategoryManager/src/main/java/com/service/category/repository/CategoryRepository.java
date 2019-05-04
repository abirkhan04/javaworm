package com.service.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.service.category.pojo.DbCategory;

public interface CategoryRepository<C> extends JpaRepository<DbCategory, Long> {

}