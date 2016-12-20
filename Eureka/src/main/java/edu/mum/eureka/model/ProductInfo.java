/**
 *
 */
package edu.mum.eureka.model;

/**
 * @author yared
 */


import edu.mum.eureka.domain.Product;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ProductInfo {
    private long code;
    private String name;
    private double price;

    private boolean newProduct = false;

    // Upload file.
    private CommonsMultipartFile fileData;

    public ProductInfo() {
    }

    public ProductInfo(Product product) {
        this.code = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public ProductInfo(long code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
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

    public CommonsMultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }

    public boolean isNewProduct() {
        return newProduct;
    }

    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }

}