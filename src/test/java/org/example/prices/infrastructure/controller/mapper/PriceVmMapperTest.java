package org.example.prices.infrastructure.controller.mapper;

import org.example.prices.domain.model.Price;
import org.example.prices.domain.model.PriceMo;
import org.example.prices.infrastructure.controller.vm.PriceVm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceVmMapperTest {

    @Test
    void shouldBeNullWhenPriceNull() {
        final PriceVmMapper priceVmMapper = new PriceVmMapper();
        final PriceVm result = priceVmMapper.toVm(null);
        Assertions.assertNull(result);
    }

    @Test
    void shouldBeNotNullWhenPriceEmpty() {
        final PriceVmMapper priceVmMapper = new PriceVmMapper();
        final PriceVm result = priceVmMapper.toVm(PriceMo.createPriceEmpty());
        Assertions.assertNotNull(result);
        Assertions.assertNull(result.priceId());
        Assertions.assertNull(result.price());
        Assertions.assertNull(result.brandId());
        Assertions.assertNull(result.currency());
        Assertions.assertNull(result.productId());
        Assertions.assertNull(result.endDate());
        Assertions.assertNull(result.startDate());
    }

    @Test
    void shouldBeNotNullWhenPriceNotNull() {
        final PriceVmMapper priceVmMapper = new PriceVmMapper();
        final Price price = PriceMo.createPrice();
        final PriceVm result = priceVmMapper.toVm(price);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(price.getId(), result.priceId());
        Assertions.assertEquals(price.getAmount(), result.price());
        Assertions.assertEquals(price.getBrand().getId(), result.brandId());
        Assertions.assertEquals(price.getCurrency(), result.currency());
        Assertions.assertEquals(price.getProduct().getId(), result.productId());
        Assertions.assertEquals(price.getEndDate(), result.endDate());
        Assertions.assertEquals(price.getStartDate(), result.startDate());
    }
}