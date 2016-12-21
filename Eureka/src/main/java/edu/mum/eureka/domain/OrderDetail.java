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

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false, unique = true)
    private long id;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "Order_Id", nullable = false, //
//            foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
    @Transient
    private Order order;


//    @OneToMany(mappedBy = "orderDetails" , fetch = FetchType.EAGER)
    @Transient
    private Product product;

    @Column(name = "Quanity", nullable = false)
    private int quanity;

    @Column(name = "Price", nullable = false)
    private double price;

    @Column(name = "Amount", nullable = false)
    private double amount;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }


}