package edu.mum.eureka.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {

    private static final long serialVersionUID = -2576670215015463100L;

    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true)
    private long id;

    @Column(name = "OrderDate", nullable = false)
    private Date orderDate;

    @Transient
    private int nextOrderDetailNum = 0;

    @Transient
    private double amount;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "CustomerId", foreignKey = @ForeignKey(name = "FK_Order_CustInfo"))
    private CustomerInfo customerInfo;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "OrderDetailId", foreignKey = @ForeignKey(name = "FK_Order_OrderDetail"))
    private List<OrderDetail> orderDetails;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getNextOrderDetailNum() {
        return nextOrderDetailNum;
    }

    public void setNextOrderDetailNum(int nextOrderDetailNum) {
        this.nextOrderDetailNum = nextOrderDetailNum;
    }

    public double getAmount() {
        if (this.orderDetails != null) {
            return this.orderDetails.stream().mapToDouble(OrderDetail::getAmount).sum();
        }
        return 0;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        if (this.orderDetails == null) {
            this.orderDetails = new ArrayList<>();
        }
        this.orderDetails.add(orderDetail);
    }

    public void removeOrderDetail(int tempId) {
        if (this.orderDetails != null) {
            Optional<OrderDetail> orderDetail = this.orderDetails.stream().filter(t -> t.getTempId() == tempId).findFirst();
            if (orderDetail.isPresent()) {
                this.orderDetails.remove(orderDetail.get());
            }
        }
    }

    public void incNextOrderDetailNum() {
        this.nextOrderDetailNum += 1;
    }
}