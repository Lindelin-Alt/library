package com.example.springboot.service.impl;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.Retur;
import com.example.springboot.mapper.ReturMapper;
import com.example.springboot.service.IReturService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ReturService implements IReturService {

    @Resource
    ReturMapper returMapper;

    @Override
    public List< Retur > list() {
        return returMapper.list();
    }

    @Override
    public PageInfo<Retur> page(BaseRequest baseRequest) {
        PageHelper.startPage( baseRequest.getPageNum(), baseRequest.getPageSize());
        return new PageInfo<>( returMapper.listByCondition( baseRequest));
    }

    @Override
    public void save(Retur obj) {
       returMapper.save(obj);
    }

    @Override
    public Retur getById(Integer id) {

        return returMapper.getById(id);
    }

    @Override
    public void update(Retur obj) {
        obj.setUpdatetime(LocalDate.now());
       returMapper.updateById(obj);
    }

    @Override
    public void deleteById(Integer id) {
       returMapper.deleteById(id);
    }

    

}
