package org.example.prices.infrastructure.persistence.mapper;


import org.example.prices.domain.model.Brand;
import org.example.prices.infrastructure.persistence.entity.BrandJpa;
import org.example.prices.infrastructure.persistence.entity.BrandJpaMo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandJpaMapperTest {

    @Test
    void shouldBeNullWhenBrandJpaNull() {
        final BrandJpaMapper brandJpaMapper = new BrandJpaMapper();
        final Brand result = brandJpaMapper.toEntity(null);
        Assertions.assertNull(result);
    }

    @Test
    void shouldBeNotNullWhenBrandJpaEmpty() {
        final BrandJpaMapper brandJpaMapper = new BrandJpaMapper();
        final Brand result = brandJpaMapper.toEntity(BrandJpaMo.createBrandJpaEmpty());
        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getId());
        Assertions.assertNull(result.getName());
    }

    @Test
    void shouldBeNotNullWhenBrandJpaNotNull() {
        final BrandJpaMapper brandJpaMapper = new BrandJpaMapper();
        final BrandJpa brandJpa = BrandJpaMo.createBrandJpa();
        final Brand result = brandJpaMapper.toEntity(brandJpa);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(brandJpa.getId(), result.getId());
        Assertions.assertEquals(brandJpa.getName(), result.getName());
    }
}