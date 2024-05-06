package org.example.prices.infrastructure.persistence.entity;

public class ProductJpaMo {

    public static ProductJpa createProductJpaEmpty(){
        return new ProductJpa();
    }

    public static ProductJpa createProductJpa(){
        final ProductJpa brandJpa = new ProductJpa();
        brandJpa.setId(18745L);
        brandJpa.setName("product name");
        return brandJpa;
    }
}