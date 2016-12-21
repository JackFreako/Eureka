package edu.mum.eureka.domain;

import javax.persistence.*;

/**
 * Created by rahul on 12/20/16.
 */

@Entity
@Table(name = "CustomerInfo")
public class CustomerInfo {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private long id;

    @Column(name = "FirstName", length = 20, nullable = false)
    private String firstName;

    @Column(name = "LastName", length = 20, nullable = true)
    private String lastName;

    @Column(name = "Address", length = 200, nullable = false)
    private String address;

    @Column(name = "Email", length = 50, nullable = false)
    private String email;

    @Column(name = "Phone", length = 10, nullable = false)
    private String phone;

    //    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Customer_Id", nullable = false, foreignKey = @ForeignKey(name = "ORDER_Customer_FK"))
    @Transient
    private Order order;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
