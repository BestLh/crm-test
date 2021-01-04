package com.sm.cn.controller.base;

import com.github.pagehelper.PageHelper;
import com.sm.cn.common.http.AxiosResult;
import com.sm.cn.entity.Brand;
import com.sm.cn.service.base.BaseService;
import com.sm.cn.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class BaseController<T,ID> {
    @Autowired
    private BaseService<T,ID> baseService;
    @GetMapping
    public AxiosResult<PageVo<T>> findPage(@RequestParam(defaultValue = "1") int current,@RequestParam(defaultValue = "5") int pageSize){
        PageHelper.startPage(current, pageSize);
        PageVo<T> pageVo = baseService.findPage();
        return AxiosResult.success(pageVo);
    }

    @GetMapping("{id}")
    public AxiosResult<T> findById(@PathVariable ID id){
        return AxiosResult.success(baseService.findById(id));
    }

    @PostMapping
    public AxiosResult<Void> addEntity(@RequestBody T entity){
        return toAxios(baseService.addEntity(entity));
    }

    @PutMapping
    public AxiosResult<Void> updateEntity(@RequestBody T entity){
        int i = baseService.updateEntity(entity);
        if (i > 0) {
            return AxiosResult.success();
        }else {
            return AxiosResult.error();
        }
    }

    @DeleteMapping("{id}")
    public AxiosResult<Void> deleteById(@PathVariable ID id){
        int i = baseService.deleteById(id);
        if (i > 0) {
            return AxiosResult.success();
        }else {
            return AxiosResult.error();
        }
    }

    public AxiosResult<Void> toAxios(int row){
        return row>0?AxiosResult.success():AxiosResult.success();
    }
}
