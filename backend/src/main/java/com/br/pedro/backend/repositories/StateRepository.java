package com.br.pedro.backend.repositories;

import com.br.pedro.backend.domains.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
