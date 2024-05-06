package org.example.prices.infrastructure.persistence.mapper;

import org.example.prices.domain.model.Price;
import org.example.prices.infrastructure.persistence.entity.PriceJpa;

public class PriceJpaMapper {

    public Price toEntity(final PriceJpa jpa) {
        if (jpa == null) {
            return null;
        }
        final Price result = new Price();
        result.setId(jpa.getId());
        result.setAmount(jpa.getPrice());
        result.setCurrency(jpa.getCurrency());
        result.setStartDate(jpa.getStartDate());
        result.setEndDate(jpa.getEndDate());
        result.setPriority(jpa.getPriority());
        final BrandJpaMapper brandJpaMapper = new BrandJpaMapper();
        result.setBrand(brandJpaMapper.toEntity(jpa.getBrand()));
        final ProductJpaMapper productJpaMapper = new ProductJpaMapper();
        result.setProduct(productJpaMapper.toEntity(jpa.getProduct()));
        return result;
    }
}
