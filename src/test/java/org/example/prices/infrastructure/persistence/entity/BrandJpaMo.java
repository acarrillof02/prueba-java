package org.example.prices.infrastructure.persistence.entity;

public class BrandJpaMo {

    public static BrandJpa createBrandJpaEmpty(){
        return new BrandJpa();
    }

    public static BrandJpa createBrandJpa(){
        final BrandJpa brandJpa = new BrandJpa();
        brandJpa.setId(77840L);
        brandJpa.setName("brand name");
        return brandJpa;
    }
}