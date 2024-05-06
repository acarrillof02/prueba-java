package org.example.prices.infrastructure.persistence.mapper;


import org.example.prices.domain.model.Price;
import org.example.prices.infrastructure.persistence.entity.PriceJpa;
import org.example.prices.infrastructure.persistence.entity.PriceJpaMo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PriceJpaMapperTest {

    @Test
    void shouldBeNullWhenPriceJpaNull() {
        final PriceJpaMapper priceJpaMapper = new PriceJpaMapper();
        final Price result = priceJpaMapper.toEntity(null);
        Assertions.assertNull(result);
    }

    @Test
    void shouldBeNotNullWhenPriceJpaEmpty() {
        final PriceJpaMapper priceJpaMapper = new PriceJpaMapper();
        final Price result = priceJpaMapper.toEntity(PriceJpaMo.createPriceJpaEmpty());
        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getId());
        Assertions.assertNull(result.getAmount());
        Assertions.assertNull(result.getBrand());
        Assertions.assertNull(result.getCurrency());
        Assertions.assertNull(result.getPriority());
        Assertions.assertNull(result.getProduct());
        Assertions.assertNull(result.getEndDate());
        Assertions.assertNull(result.getStartDate());
    }

    @Test
    void shouldBeNotNullWhenPriceJpaNotNull() {
        final PriceJpaMapper priceJpaMapper = new PriceJpaMapper();
        final PriceJpa priceJpa = PriceJpaMo.createPriceJpa();
        final Price result = priceJpaMapper.toEntity(priceJpa);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(priceJpa.getId(), result.getId());
        Assertions.assertEquals(priceJpa.getPrice(), result.getAmount());
        Assertions.assertEquals(priceJpa.getBrand().getId(), result.getBrand().getId());
        Assertions.assertEquals(priceJpa.getBrand().getName(), result.getBrand().getName());
        Assertions.assertEquals(priceJpa.getCurrency(), result.getCurrency());
        Assertions.assertEquals(priceJpa.getPriority(), result.getPriority());
        Assertions.assertEquals(priceJpa.getProduct().getId(), result.getProduct().getId());
        Assertions.assertEquals(priceJpa.getProduct().getName(), result.getProduct().getName());
        Assertions.assertEquals(priceJpa.getEndDate(), result.getEndDate());
        Assertions.assertEquals(priceJpa.getStartDate(), result.getStartDate());
    }
}