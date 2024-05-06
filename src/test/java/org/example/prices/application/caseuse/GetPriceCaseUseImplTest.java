package org.example.prices.application.caseuse;

import org.example.prices.domain.model.Price;
import org.example.prices.domain.model.PriceMo;
import org.example.prices.domain.repository.PriceRepository;
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
class GetPriceCaseUseImplTest {

    @Mock
    private PriceRepository priceRepository;
    private GetPriceCaseUseImpl getPriceCaseUse;

    @BeforeEach
    public void init() {
        getPriceCaseUse = new GetPriceCaseUseImpl(priceRepository);
    }

    @Test
    void shouldBeEmptyWhenNotData() {
        final LocalDateTime date = LocalDateTime.now();
        final Long productId = 8245L;
        final Long brandId = 98945L;
        Mockito.when(priceRepository.getPriceByDateProductIdBrandId(date, productId, brandId))
                .thenReturn(Optional.empty());
        Optional<Price> result = getPriceCaseUse.getPrice(date, productId, brandId);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void shouldBeNotEmptyWhenData() {
        final LocalDateTime date = LocalDateTime.now();
        final Long productId = 8245L;
        final Long brandId = 98945L;
        final Price price = PriceMo.createPrice();
        Mockito.when(priceRepository.getPriceByDateProductIdBrandId(date, productId, brandId))
                .thenReturn(Optional.of(price));
        Optional<Price> result = getPriceCaseUse.getPrice(date, productId, brandId);
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(price, result.get());
    }
}