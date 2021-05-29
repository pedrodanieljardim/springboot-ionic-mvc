package com.br.pedro.backend.repositories;

import com.br.pedro.backend.domains.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress, Long> {
}
