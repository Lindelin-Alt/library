package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.Retur;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReturMapper {

    List<Retur> list();

    List<Retur> listByCondition(BaseRequest baseRequest);

    void save(Retur obj);

    Retur getById(Integer id);

    void updateById(Retur user);

    void deleteById(Integer id);
}
