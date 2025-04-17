package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class PasswordRequest {
    private String username;
    private String password;
    public String newPass;
}
