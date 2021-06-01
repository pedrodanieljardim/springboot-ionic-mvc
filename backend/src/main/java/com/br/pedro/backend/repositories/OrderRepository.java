package com.br.pedro.backend.repositories;

import com.br.pedro.backend.domains.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
