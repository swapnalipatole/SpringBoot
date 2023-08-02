package com.api.dto;

import java.time.LocalDate;

public class ProductDTO {
    private Integer ProductId;
    private String emailId;
    private String name;
    private LocalDate dateOfBirth;
    private ProductType productType;
    public Integer getProductId() {
        return ProductId;
    }
    public void setProductId(Integer ProductId) {
        this.ProductId = ProductId;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public ProductType getProductType() {
        return productType;
    }
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
    @Override
    public String toString() {
        return "ProductDTO [ProductId=" + ProductId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth="
                + dateOfBirth + "]";
    }

}
