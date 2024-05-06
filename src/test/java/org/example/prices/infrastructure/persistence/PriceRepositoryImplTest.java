package org.example.prices.infrastructure.persistence;

import org.example.prices.domain.model.Price;
import org.example.prices.infrastructure.persistence.entity.PriceJpa;
import org.example.prices.infrastructure.persistence.entity.PriceJpaMo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PriceRepositoryImplTest {

    @Mock
    private PriceRepositoryJpa priceRepositoryJpa;

    private PriceRepositoryImpl priceRepositoryImpl;

    @BeforeEach
    public void init() {
        priceRepositoryImpl = new PriceRepositoryImpl(priceRepositoryJpa);
    }

    @Test
    void shouldBeEmptyWhenNotExistData() {
        final LocalDateTime date = LocalDateTime.now();
        final Long productId = 1243L;
        final Long brandId = 65345L;
        final PriceJpa priceJpa = PriceJpaMo.createPriceJpa();
        Mockito.when(priceRepositoryJpa.getPriceByDateProductIdBrandId(date, productId, brandId)).thenReturn(Optional.empty());
        Optional<Price> result = priceRepositoryImpl.getPriceByDateProductIdBrandId(date, productId, brandId);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void shouldBeNotNullWhenExistData() {
        final LocalDateTime date = LocalDateTime.now();
        final Long productId = 1243L;
        final Long brandId = 65345L;
        final PriceJpa priceJpa = PriceJpaMo.createPriceJpa();
        Mockito.when(priceRepositoryJpa.getPriceByDateProductIdBrandId(date, productId, brandId)).thenReturn(Optional.of(priceJpa));
        Optional<Price> result = priceRepositoryImpl.getPriceByDateProductIdBrandId(date, productId, brandId);
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.get());
        Assertions.assertEquals(priceJpa.getId(), result.get().getId());
        Assertions.assertEquals(priceJpa.getPrice(), result.get().getAmount());
        Assertions.assertEquals(priceJpa.getBrand().getId(), result.get().getBrand().getId());
        Assertions.assertEquals(priceJpa.getBrand().getName(), result.get().getBrand().getName());
        Assertions.assertEquals(priceJpa.getCurrency(), result.get().getCurrency());
        Assertions.assertEquals(priceJpa.getPriority(), result.get().getPriority());
        Assertions.assertEquals(priceJpa.getProduct().getId(), result.get().getProduct().getId());
        Assertions.assertEquals(priceJpa.getProduct().getName(), result.get().getProduct().getName());
        Assertions.assertEquals(priceJpa.getEndDate(), result.get().getEndDate());
        Assertions.assertEquals(priceJpa.getStartDate(), result.get().getStartDate());
    }
}