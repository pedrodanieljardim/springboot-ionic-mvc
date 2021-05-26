package com.br.pedro.backend.services;

import com.br.pedro.backend.domains.Category;
import com.br.pedro.backend.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category searchCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long idCategory, Category newCategory){
        Category oldCategory = categoryRepository.findById(idCategory).get();
        oldCategory.setName(newCategory.getName());
        return categoryRepository.save(oldCategory);
    }

    public void removeCategory(Long idCategory){
        categoryRepository.deleteById(idCategory);
    }

}
