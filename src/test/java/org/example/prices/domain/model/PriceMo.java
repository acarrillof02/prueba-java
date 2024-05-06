package org.example.prices.domain.model;

import org.example.prices.infrastructure.persistence.entity.BrandJpaMo;
import org.example.prices.infrastructure.persistence.entity.PriceJpa;
import org.example.prices.infrastructure.persistence.entity.ProductJpaMo;

import java.time.LocalDateTime;

public class PriceMo {

    public static Price createPriceEmpty(){
        return new Price();
    }

    public static  Price createPrice(){
        final Price price = new Price();
        price.setId(689505L);
        price.setBrand(BrandMo.createBrand());
        price.setCurrency("EUR");
        price.setPriority(1);
        price.setAmount(56.99f);
        price.setProduct(ProductMo.createProduct());
        price.setEndDate(LocalDateTime.parse("2020-01-01T00:00:00"));
        price.setStartDate(LocalDateTime.parse("2020-02-01T00:00:00"));
        return price;
    }
}