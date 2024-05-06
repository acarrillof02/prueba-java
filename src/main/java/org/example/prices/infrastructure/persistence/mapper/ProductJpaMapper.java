package org.example.prices.infrastructure.persistence.mapper;

import org.example.prices.domain.model.Product;
import org.example.prices.infrastructure.persistence.entity.ProductJpa;

public class ProductJpaMapper {

    public Product toEntity(final ProductJpa jpa) {
        if (jpa == null) {
            return null;
        }
        final Product result = new Product();
        result.setId(jpa.getId());
        result.setName(jpa.getName());
        return result;
    }
}
