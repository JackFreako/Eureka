/**
 *
 */
package edu.mum.eureka.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "OrderDetails")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 7550745928843183535L;

    @GeneratedValue
    @Column(name = "Id", nullable = false, unique = true)
    @Id
    private long id;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "ProductId")
    private Product product;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "Price", nullable = false)
    private double price;

    @Transient
    private double amount;
    
    
    public OrderDetail() {}
    
    public OrderDetail (Integer  quantity,  Product product ) {
	   this.quantity = quantity;
	   this.product = product;
    }
    
    @Transient
    private int tempId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return this.quantity * this.price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTempId() {
        return tempId;
    }

    public void setTempId(int tempId) {
        this.tempId = tempId;
    }
}