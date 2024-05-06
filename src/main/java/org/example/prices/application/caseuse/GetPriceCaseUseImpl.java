package org.example.prices.application.caseuse;

import org.example.prices.domain.caseuse.GetPriceCaseUse;
import org.example.prices.domain.model.Price;
import org.example.prices.domain.repository.PriceRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public class GetPriceCaseUseImpl implements GetPriceCaseUse {

    private final PriceRepository priceRepository;
    public GetPriceCaseUseImpl(final PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Optional<Price> getPrice(final LocalDateTime date, final Long productId, final Long brandId) {
        return priceRepository.getPriceByDateProductIdBrandId(date, productId, brandId);
    }
}
