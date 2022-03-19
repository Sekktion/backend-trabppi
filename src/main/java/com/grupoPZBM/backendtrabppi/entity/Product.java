package com.grupoPZBM.backendtrabppi.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "price", nullable = false)
    private long price;

    @Column(name = "desc", nullable = false)
    private String desc;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getImage() {
        return image;
    }

    public long getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}