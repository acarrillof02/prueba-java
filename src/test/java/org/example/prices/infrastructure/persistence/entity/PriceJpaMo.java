package org.example.prices.infrastructure.persistence.entity;

import java.time.LocalDateTime;

public class PriceJpaMo {

    public static  PriceJpa createPriceJpaEmpty(){
        return new PriceJpa();
    }

    public static  PriceJpa createPriceJpa(){
        final PriceJpa priceJpa = new PriceJpa();
        priceJpa.setId(689505L);
        priceJpa.setBrand(BrandJpaMo.createBrandJpa());
        priceJpa.setCurrency("EUR");
        priceJpa.setPriority(1);
        priceJpa.setPrice(56.99f);
        priceJpa.setProduct(ProductJpaMo.createProductJpa());
        priceJpa.setEndDate(LocalDateTime.parse("2020-01-01T00:00:00"));
        priceJpa.setStartDate(LocalDateTime.parse("2020-02-01T00:00:00"));
        return priceJpa;
    }
}