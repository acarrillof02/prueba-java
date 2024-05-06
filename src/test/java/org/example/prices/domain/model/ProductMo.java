package org.example.prices.domain.model;

import org.example.prices.infrastructure.persistence.entity.ProductJpa;

public class ProductMo {

    public static Product createProductEmpty(){
        return new Product();
    }

    public static Product createProduct(){
        final Product product = new Product();
        product.setId(18745L);
        product.setName("product name");
        return product;
    }
}