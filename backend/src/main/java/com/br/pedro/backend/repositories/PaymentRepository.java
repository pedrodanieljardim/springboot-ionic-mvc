package com.br.pedro.backend.repositories;

import com.br.pedro.backend.domains.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
