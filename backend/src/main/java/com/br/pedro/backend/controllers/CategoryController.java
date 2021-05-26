package com.br.pedro.backend.controllers;

import com.br.pedro.backend.domains.Category;
import com.br.pedro.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> findAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable("id") Long categoryId){
        return ResponseEntity.ok().body(categoryService.searchCategoryById(categoryId));
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        Category newCategory = categoryService.createCategory(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCategory.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateCategory(@PathVariable("id") Long categoryId, @RequestBody Category category){
        categoryService.updateCategory(categoryId, category);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long categoryId){
        categoryService.removeCategory(categoryId);
        return ResponseEntity.noContent().build();
    }

}
