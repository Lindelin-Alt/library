package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Retur  {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String bookName;
    private String bookNo;
    private Integer userId;
    private String userName;
    private String userPhone;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate createtime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private  LocalDate updatetime;
    private Integer score;
    private String status;
    private Integer days;
    private String returnDate;
    private String realDate;


}