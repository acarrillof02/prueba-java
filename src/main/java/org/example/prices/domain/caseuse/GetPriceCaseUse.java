package org.example.prices.domain.caseuse;

import org.example.prices.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface GetPriceCaseUse {
    Optional<Price> getPrice(LocalDateTime date, Long productId, Long brandId);

}
