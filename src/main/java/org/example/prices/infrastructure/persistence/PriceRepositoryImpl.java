package org.example.prices.infrastructure.persistence;

import org.example.prices.domain.model.Price;
import org.example.prices.domain.repository.PriceRepository;
import org.example.prices.infrastructure.persistence.entity.PriceJpa;
import org.example.prices.infrastructure.persistence.mapper.PriceJpaMapper;

import java.time.LocalDateTime;
import java.util.Optional;

public class PriceRepositoryImpl implements PriceRepository {

    private PriceRepositoryJpa priceRepositoryJpa;

    public PriceRepositoryImpl(PriceRepositoryJpa priceRepositoryJpa) {
        this.priceRepositoryJpa = priceRepositoryJpa;
    }

    @Override
    public Optional<Price> getPriceByDateProductIdBrandId(final LocalDateTime date,
                                                          final Long productId, final Long brandId) {
        final Optional<PriceJpa> priceJpa = priceRepositoryJpa.getPriceByDateProductIdBrandId(date, productId, brandId);
        final PriceJpaMapper priceJpaMapper = new PriceJpaMapper();
        return Optional.ofNullable(priceJpaMapper.toEntity(priceJpa.orElse(null)));
    }
}