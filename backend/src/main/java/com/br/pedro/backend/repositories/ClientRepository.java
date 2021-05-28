package com.br.pedro.backend.repositories;

import com.br.pedro.backend.domains.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
