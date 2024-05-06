package org.example.prices.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "BRANDS")
public class BrandJpa {

    @Id
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
