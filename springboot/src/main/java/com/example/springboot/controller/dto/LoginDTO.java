package com.example.springboot.controller.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String id;
    private String username;
    private String phone;
    private String email;
    private String token;
}
