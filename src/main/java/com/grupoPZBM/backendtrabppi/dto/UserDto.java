package com.grupoPZBM.backendtrabppi.dto;

import javax.validation.constraints.NotBlank;

public class UserDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
