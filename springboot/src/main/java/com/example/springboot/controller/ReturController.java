package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.ReturPageRequest;
import com.example.springboot.entity.Retur;
import com.example.springboot.service.IReturService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/retur")
public class ReturController {

    @Autowired
    IReturService returService;

    @PostMapping("/save")
    public Result save(@RequestBody Retur obj) {
        returService.save(obj);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Retur obj) {
        returService.update(obj);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        returService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Retur obj = returService.getById(id);
        return  Result.success(obj);
    }

    @GetMapping("/list")
    public Result list() {
        List<Retur> list = returService.list();
        return  Result.success(list);
    }
    @GetMapping("/page")
    public Result page(ReturPageRequest pageRequest) {
        return  Result.success(returService.page(pageRequest));
    }
}
