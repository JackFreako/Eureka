package edu.mum.eureka.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {

    private static final long serialVersionUID = -2576670215015463100L;


    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true)
    private String id;


    @Column(name = "OrderDate", nullable = false)
    private Date orderDate;

    @Column(name = "OrderNum", nullable = false)
    private int orderNum;

    @Column(name = "Amount", nullable = false)
    private double amount;

    @Transient
    private Customer customer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }



}