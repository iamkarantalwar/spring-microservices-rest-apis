package com.example.demo.product.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "options")
public class Option {

	@Id
	@GeneratedValue
	private long id;
	
    private String optionName;
    	
}
