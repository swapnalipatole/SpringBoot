package com.api.entity;

import com.api.dto.ProductType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Product {
    @Id
    private Integer ProductId;
    private String emailId;
    private String name;
    private LocalDate dateOfBirth;
    @Enumerated(value= EnumType.STRING)
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
        return "Product [ProductId=" + ProductId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth="
                + dateOfBirth + ", ProductType=" + productType + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getProductId() == null) ? 0 : this.getProductId().hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (this.getProductId() == null) {
            if (other.getProductId() != null)
                return false;
        }
        else if (!this.getProductId().equals(other.getProductId()))
            return false;
        return true;
    }

}
