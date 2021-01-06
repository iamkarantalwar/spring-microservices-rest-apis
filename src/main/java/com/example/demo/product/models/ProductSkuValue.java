package com.example.demo.product.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "product_sku_values")
public class ProductSkuValue {
    
	@Id
	@GeneratedValue
    private long id;

    private long productId;

    private long productSkuId;

    private long productOptionId;

    private String productOptionValue;

}
