package com.grupoPZBM.backendtrabppi.dto;

import com.grupoPZBM.backendtrabppi.configs.UUIDConfig;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class productDto {

    @Size (max = 50)
    private String productName;
    @Size (max = 200)
    private String productDescription;
    @Size (max = 50)
    private String productType;
    private String productImage;
    private long productPrice;
//    @UUIDConfig.UUID
//    private UUID productOwnerId;

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

    public void setCategory(String category) {
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

//    public UUID getUserID() {
//        return productOwnerId;
//    }
//
//    public void setUserID(UUID productOwnerId) {
//        this.productOwnerId = productOwnerId;
//    }
}
