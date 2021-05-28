package com.br.pedro.backend;

import com.br.pedro.backend.domains.Category;
import com.br.pedro.backend.domains.City;
import com.br.pedro.backend.domains.Product;
import com.br.pedro.backend.domains.State;
import com.br.pedro.backend.repositories.CategoryRepository;
import com.br.pedro.backend.repositories.CityRepository;
import com.br.pedro.backend.repositories.ProductRepository;
import com.br.pedro.backend.repositories.StateRepository;
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

    @Autowired
    CityRepository cityRepository;

    @Autowired
    StateRepository stateRepository;

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

        State s1 = State.builder().name("Minas Gerais").build();
        State s2 = State.builder().name("São Paulo").build();

        City c1 = City.builder().name("Belo Horizonte").state(s1).build();
        City c2 = City.builder().name("Uberlândia").state(s1).build();
        City c3 = City.builder().name("São Paulo").state(s2).build();
        City c4 = City.builder().name("Campinas").state(s2).build();

        s1.setCities(Arrays.asList(c1, c2));
        s2.setCities(Arrays.asList(c3, c4));

        cat1.setProductList(Arrays.asList(p1,p2,p3));
        cat2.setProductList(Arrays.asList(p2));

        p1.setCategoryList(Arrays.asList(cat1));
        p2.setCategoryList(Arrays.asList(cat1, cat2));
        p3.setCategoryList(Arrays.asList(cat1));

        stateRepository.saveAll(Arrays.asList(s1, s2));
        cityRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}
