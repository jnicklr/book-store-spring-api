package com.book.store.api.book_store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.api.book_store.domain.Category;
import com.book.store.api.book_store.dto.CategoryDTO;
import com.book.store.api.book_store.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        Category savedCategory = categoryRepository.save(category);
        return convertToDTO(savedCategory);
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    public CategoryDTO getCategoryById(Long id) {
        Optional<Category> categoryOpt = categoryRepository.findById(id);
        return categoryOpt.map(this::convertToDTO).orElse(null);
    }

    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        if (categoryRepository.existsById(id)) {
            Category category = new Category();
            category.setId(id);
            category.setName(categoryDTO.getName());
            Category updatedCategory = categoryRepository.save(category);
            return convertToDTO(updatedCategory);
        }
        return null;
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);;
    }

    private CategoryDTO convertToDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }
}
