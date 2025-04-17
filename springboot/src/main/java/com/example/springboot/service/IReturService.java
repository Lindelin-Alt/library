package com.example.springboot.service;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.Retur;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IReturService {

    List<Retur> list();

    PageInfo<Retur> page(BaseRequest baseRequest);

    void save(Retur obj);

    Retur getById(Integer id);

    void update(Retur obj);

    void deleteById(Integer id);
}
