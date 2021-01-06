package com.example.demo.product.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "product_skus")
public class ProductSku {
	@Id
	@GeneratedValue
    private long id;

    private String sku;
    
    private long productId;

    private float price;

    private float discount;
}
