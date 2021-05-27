package com.br.pedro.backend;

import com.br.pedro.backend.domains.Category;
import com.br.pedro.backend.domains.Product;
import com.br.pedro.backend.repositories.CategoryRepository;
import com.br.pedro.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = Category.builder().name("Informática").build();
        Category cat2 = Category.builder().name("Escritório").build();

        Product p1 = Product.builder().name("Computador").price(2000.00).build();
        Product p2 = Product.builder().name("Impressora").price(300.00).build();
        Product p3 = Product.builder().name("Mouse").price(80.00).build();

        cat1.setProductList(Arrays.asList(p1,p2,p3));
        cat2.setProductList(Arrays.asList(p2));

        p1.setCategoryList(Arrays.asList(cat1));
        p2.setCategoryList(Arrays.asList(cat1, cat2));
        p3.setCategoryList(Arrays.asList(cat1));

        productRepository.saveAll(Arrays.asList(p1, p2, p3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));


    }
}
