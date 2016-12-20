package edu.mum.eureka.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Products")
public class Product implements Serializable {

    private static final long serialVersionUID = -1000119078147252957L;


    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true)
    private long id;

    @Column(name = "Name", length = 25, nullable = false)
    private String name;

    @Column(name = "Price", nullable = false)
    private double price;

    @Column(name = "Description", length = 255)
    private String description;

//    private byte[] image;

    // For sort.
//    private Date createDate;

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long code) {
        this.id = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "Create_Date", nullable = false)
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }

//    @Lob
//    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }

}
