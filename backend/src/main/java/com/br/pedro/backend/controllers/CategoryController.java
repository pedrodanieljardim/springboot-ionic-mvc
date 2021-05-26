package com.br.pedro.backend.controllers;

import com.br.pedro.backend.domains.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @GetMapping
    public List<Category> allCategories(){
        Category c1 = new Category(1L, "Informática");
        Category c2 = new Category(2L, "Escritório");

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(c1);
        categoryList.add(c2);

        return categoryList;
    }

}
