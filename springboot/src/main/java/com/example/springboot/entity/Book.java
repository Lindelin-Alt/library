package com.example.springboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Book extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private String publishDate;
    private String author;
    private String publisher;
    private String category;
    private String bookNo   ;
    private String cover;
    //@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    //private LocalDate createtime;
    //@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
   // private LocalDate updatetime;
    private List<String> categories;

}
