package com.example.nizam.app.data.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ITEM")
@JsonIgnoreProperties({ "createdDate" })
@Data
@NoArgsConstructor
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
}
