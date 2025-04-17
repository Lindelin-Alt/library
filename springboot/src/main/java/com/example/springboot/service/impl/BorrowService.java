package com.example.springboot.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.Borrow;
import com.example.springboot.mapper.BorrowMapper;
import com.example.springboot.service.IBorrowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class BorrowService implements IBorrowService {

    @Resource
    BorrowMapper borrowMapper;

    @Override
    public List< Borrow > list() {
        return borrowMapper.list();
    }

    @Override
    public PageInfo<Borrow> page(BaseRequest baseRequest) {
        PageHelper.startPage( baseRequest.getPageNum(), baseRequest.getPageSize());
        return new PageInfo<>( borrowMapper.listByCondition( baseRequest));
    }

    @Override
    public void save(Borrow obj) {
       borrowMapper.save(obj);
    }

    @Override
    public Borrow getById(Integer id) {

        return borrowMapper.getById(id);
    }

    @Override
    public void update(Borrow obj) {
        obj.setUpdatetime(LocalDate.now());
       borrowMapper.updateById(obj);
    }

    @Override
    public void deleteById(Integer id) {
       borrowMapper.deleteById(id);
    }

    

}
