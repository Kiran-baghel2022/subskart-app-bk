package com.subskart.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subskart.entity.Category;
import com.subskart.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	public CategoryRepository categoryRepository;

	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> categories() {
		return categoryRepository.findAll();
	}
}
