package com.grupoPZBM.backendtrabppi.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId")
    private UUID productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "productType")
    private String productType;

    @Column(name = "productImage")
    private String productImage;

    @Column(name = "productPrice")
    private long productPrice;

    @Column(name = "productOwner")
    private UUID productOwnerId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "users.id")
    private User user;


    public UUID getId() {
        return productId;
    }

    public void setId(UUID productId) {
        this.productId = productId;
    }

    public String getName() {
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return productDescription;
    }

    public void setDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getCategory() {
        return productType;
    }

    public void setCategory(String productType) {
        this.productType = productType;
    }

    public String getImage() {
        return productImage;
    }

    public void setImage(String productImage) {
        this.productImage = productImage;
    }

    public long getPrice() {
        return productPrice;
    }

    public void setPrice(long productPrice) {
        this.productPrice = productPrice;
    }

    public UUID getUsername() {
        return productOwnerId;
    }

    public void setUsername(UUID productOwnerId) {
        this.productOwnerId = productOwnerId;
    }

}