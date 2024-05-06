package org.example.prices.domain.model;

import org.example.prices.infrastructure.persistence.entity.BrandJpa;

import static org.junit.jupiter.api.Assertions.*;

public class BrandMo {

    public static Brand createBrandEmpty(){
        return new Brand();
    }

    public static Brand createBrand(){
        final Brand brand = new Brand();
        brand.setId(77840L);
        brand.setName("brand name");
        return brand;
    }
}