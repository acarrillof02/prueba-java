package org.example.prices.infrastructure.persistence.mapper;


import org.example.prices.domain.model.Brand;
import org.example.prices.infrastructure.persistence.entity.BrandJpa;

public class BrandJpaMapper {

    public Brand toEntity(final BrandJpa jpa) {
        if (jpa == null) {
            return  null;
        }
        final Brand result = new Brand();
        result.setId(jpa.getId());
        result.setName(jpa.getName());
        return result;
    }
}
