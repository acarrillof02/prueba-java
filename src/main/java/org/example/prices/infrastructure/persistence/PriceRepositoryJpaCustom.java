package org.example.prices.infrastructure.persistence;

import org.example.prices.infrastructure.persistence.entity.PriceJpa;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryJpaCustom {

    Optional<PriceJpa> getPriceByDateProductIdBrandId(LocalDateTime date, Long productId, Long brandId);
}

