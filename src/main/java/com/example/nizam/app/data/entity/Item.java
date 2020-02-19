package com.example.nizam.app.data.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ITEM")
@JsonIgnoreProperties({ "createdDate" })
public class Item {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    @Column(name = "DESCRIPTION")
    private String shortDescription;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "BRAND")
    private String brand;
    @Column(name = "CREATED_DATE")
    private Date createdDate;


    public Item() {
    }


    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(itemId, item.itemId) && Objects.equals(shortDescription, item.shortDescription) && Objects.equals(price, item.price) && Objects.equals(brand, item.brand) && Objects.equals(createdDate, item.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, shortDescription, price, brand, createdDate);
    }

    @Override
    public String toString() {
        return "{" +
            " itemId='" + getItemId() + "'" +
            ", shortDescription='" + getShortDescription() + "'" +
            ", price='" + getPrice() + "'" +
            ", brand='" + getBrand() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            "}";
    }


}
