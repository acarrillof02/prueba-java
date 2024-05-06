package org.example.prices.infrastructure.persistence;

import org.example.prices.infrastructure.persistence.entity.PriceJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepositoryJpa extends JpaRepository<PriceJpa, Long>, PriceRepositoryJpaCustom {

}

