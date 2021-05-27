package com.br.pedro.backend.repositories;

import com.br.pedro.backend.domains.Category;
import com.br.pedro.backend.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
