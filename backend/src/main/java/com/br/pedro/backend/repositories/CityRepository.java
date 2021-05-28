package com.br.pedro.backend.repositories;

import com.br.pedro.backend.domains.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
