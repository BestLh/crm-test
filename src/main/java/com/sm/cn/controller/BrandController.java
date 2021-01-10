package com.sm.cn.controller;

import com.github.pagehelper.PageHelper;
import com.sm.cn.common.http.AxiosResult;
import com.sm.cn.controller.base.BaseController;
import com.sm.cn.entity.Brand;
import com.sm.cn.service.BrandService;
import com.sm.cn.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController extends BaseController{
    @Autowired
    private BrandService brandService;
    @GetMapping
    public AxiosResult<PageVo<Brand>> findPage(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        PageVo<Brand> pageVo = brandService.findPage();
        return AxiosResult.success(pageVo);
    }

    @GetMapping("{id}")
    public AxiosResult<Brand> findById(@PathVariable Long id){
        return AxiosResult.success(brandService.findById(id));
    }

    @PostMapping
    public AxiosResult<Void> addEntity(@RequestBody Brand entity){
        return toAxios(brandService.addEntity(entity));
    }

    @PutMapping
    public AxiosResult<Void> updateEntity(@RequestBody Brand entity){
        int i = brandService.updateEntity(entity);
        if (i > 0) {
            return AxiosResult.success();
        }else {
            return AxiosResult.error();
        }
    }

    @DeleteMapping("{ids}")
    public AxiosResult<Void> deleteById(@PathVariable List<Long> ids){
        return toAxios(brandService.batchDeleteByIds(ids));
    }
}
