package com.example.crud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table (name = "tbl_products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="title", length =1000, nullable =false)
    private String title;
    @Column(name = "price", precision = 13, scale = 2, nullable = false)
    private BigDecimal price;
    @Column(name = "price_sale", precision = 13, scale = 2, nullable = true)
    private BigDecimal priceSale;
    @Column(name = "short_description", length = 3000, nullable = false)
    private String shortDes;
    @Lob
    @Column(name = "detail_description", nullable = false, columnDefinition = "LONGTEXT")
    private String details;
    @Column(name = "avatar", nullable = true)
    private String avatar;
    @Column(name = "seo", length = 1000, nullable = true)
    private String seo;
    @Column(name = "is_hot", nullable = true)
    private Boolean isHot = Boolean.FALSE;
}

