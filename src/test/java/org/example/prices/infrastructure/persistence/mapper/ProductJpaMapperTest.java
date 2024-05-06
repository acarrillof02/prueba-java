package org.example.prices.infrastructure.persistence.mapper;

import org.example.prices.domain.model.Product;
import org.example.prices.infrastructure.persistence.entity.ProductJpa;
import org.example.prices.infrastructure.persistence.entity.ProductJpaMo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductJpaMapperTest {

    @Test
    void shouldBeNullWhenProductJpaNull() {
        final ProductJpaMapper productJpaMapper = new ProductJpaMapper();
        final Product result = productJpaMapper.toEntity(null);
        Assertions.assertNull(result);
    }

    @Test
    void shouldBeNotNullWhenProductJpaEmpty() {
        final ProductJpaMapper productJpaMapper = new ProductJpaMapper();
        final Product result = productJpaMapper.toEntity(ProductJpaMo.createProductJpaEmpty());
        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getId());
        Assertions.assertNull(result.getName());
    }

    @Test
    void shouldBeNotNullWhenProductJpaNotNull() {
        final ProductJpaMapper productJpaMapper = new ProductJpaMapper();
        final ProductJpa productJpa = ProductJpaMo.createProductJpa();
        final Product result = productJpaMapper.toEntity(productJpa);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(productJpa.getId(), result.getId());
        Assertions.assertEquals(productJpa.getName(), result.getName());
    }
}