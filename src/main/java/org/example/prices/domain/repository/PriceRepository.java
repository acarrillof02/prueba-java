package org.example.prices.domain.repository;

import org.example.prices.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {
    Optional<Price> getPriceByDateProductIdBrandId(LocalDateTime date, Long productId, Long brandId);
}
