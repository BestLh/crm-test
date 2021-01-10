package com.sm.cn.controller;

import com.github.pagehelper.PageHelper;
import com.sm.cn.common.http.AxiosResult;
import com.sm.cn.controller.base.BaseController;
import com.sm.cn.entity.Supplier;
import com.sm.cn.service.SupplierService;
import com.sm.cn.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier")
public class SupplierController extends BaseController<Supplier,Long> {
    @Autowired
    private SupplierService supplierService;
    @GetMapping
    public AxiosResult<PageVo<Supplier>> findPage(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        PageVo<Supplier> pageVo = supplierService.findPage();
        return AxiosResult.success(pageVo);
    }

    @GetMapping("{id}")
    public AxiosResult<Supplier> findById(@PathVariable Long id){
        return AxiosResult.success(supplierService.findById(id));
    }

    @PostMapping
    public AxiosResult<Void> addEntity(@RequestBody Supplier entity){
        return toAxios(supplierService.addEntity(entity));
    }

    @PutMapping
    public AxiosResult<Void> updateEntity(@RequestBody Supplier entity){
        int i = supplierService.updateEntity(entity);
        if (i > 0) {
            return AxiosResult.success();
        }else {
            return AxiosResult.error();
        }
    }

    @DeleteMapping("{ids}")
    public AxiosResult<Void> deleteById(@PathVariable List<Long> ids){
        return toAxios(supplierService.batchDeleteByIds(ids));
    }
}
