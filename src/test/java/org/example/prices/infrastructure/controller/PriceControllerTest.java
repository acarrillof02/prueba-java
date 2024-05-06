package org.example.prices.infrastructure.controller;

import org.example.prices.domain.caseuse.GetPriceCaseUse;
import org.example.prices.domain.model.Price;
import org.example.prices.domain.model.PriceMo;
import org.example.prices.infrastructure.controller.vm.PriceVm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @Mock
    private GetPriceCaseUse getPriceCaseUse;
    private PriceController priceController;

    @BeforeEach
    public void init() {
        priceController = new PriceController(getPriceCaseUse);
    }

    @Test
    void ShouldBeNotFoundWhenNotExistPrice() {
        final LocalDateTime date = LocalDateTime.now();
        final Long productId = 3984l;
        final Long brandId = 983247l;
        Mockito.when(getPriceCaseUse.getPrice(date, productId, brandId)).thenReturn(Optional.empty());
        final ResponseEntity<PriceVm> result = priceController.getPrice(date, productId, brandId);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        Assertions.assertNull(result.getBody());
    }

    @Test
    void ShouldBeOkWhenExistPrice() {
        final LocalDateTime date = LocalDateTime.now();
        final Long productId = 3984l;
        final Long brandId = 983247l;
        final Price price = PriceMo.createPrice();
        Mockito.when(getPriceCaseUse.getPrice(date, productId, brandId)).thenReturn(Optional.of(price));
        final ResponseEntity<PriceVm> result = priceController.getPrice(date, productId, brandId);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertNotNull(result.getBody());
        final PriceVm expect = new PriceVm(price.getProduct().getId(), price.getBrand().getId(), price.getStartDate(), price.getEndDate()
                , price.getId(), price.getAmount(), price.getCurrency());
        Assertions.assertEquals(expect, result.getBody());
    }
}