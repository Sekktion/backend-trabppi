package com.grupoPZBM.backendtrabppi.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

public class UserDto {
    @NotBlank
    @Size(max = 30)
    private String username;
    @NotBlank
    @Size(max = 20)
    private String password;
    @NotBlank
    @Email
    private String email;
    private String address;
    private String phoneNum;

    private List<UUID> products;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

//    public List<UUID> getProducts() { return products; };

//    public void setProducts(UUID productID) {
//        this.products.add(productID);
//    }
}
