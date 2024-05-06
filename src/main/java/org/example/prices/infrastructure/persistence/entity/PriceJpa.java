package org.example.prices.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "PRICES")
public class PriceJpa {

    @Id
    @Column(name = "PRICE_LIST")
    private Long id;

    @ManyToOne
    private BrandJpa brand;

    @ManyToOne
    private ProductJpa product;

    /** Higher Priority Higher Numeric Value **/
    private Integer priority;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    private Float price;

    @Column(name = "CURR")
    /** Currency in ISO code **/
    private String currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BrandJpa getBrand() {
        return brand;
    }

    public void setBrand(BrandJpa brand) {
        this.brand = brand;
    }

    public ProductJpa getProduct() {
        return product;
    }

    public void setProduct(ProductJpa product) {
        this.product = product;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
