package edu.mum.eureka.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Product")
public class Product implements Serializable {
    private static final long serialVersionUID = 5784L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;

    
    @NotEmpty
    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    //@Pattern(regexp="^[1-9]\\d$",message="{Product.price.valid}")
    //@NotNull
    @Column(name = "Price")
    private float price;      
    
    public Product() {}
    
    
	public Product (String name, String description,float price ) {
		   this.name = name;
		   this.description = description;
		   this.price = price;
	   }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}