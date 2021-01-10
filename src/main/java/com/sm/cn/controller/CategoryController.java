package com.sm.cn.controller;

import com.github.pagehelper.PageHelper;
import com.sm.cn.common.http.AxiosResult;
import com.sm.cn.controller.base.BaseController;
import com.sm.cn.entity.Category;
import com.sm.cn.service.CategoryService;
import com.sm.cn.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController extends BaseController<Category,Long> {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("getTreeData")
    public AxiosResult<List<Category>> getTreeData(){
        List<Category> list = categoryService.getTreeData();
        return AxiosResult.success(list);
    }


    @GetMapping
    public AxiosResult<PageVo<Category>> findPage(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        PageVo<Category> pageVo = categoryService.findPage();
        return AxiosResult.success(pageVo);
    }

    @GetMapping("{id}")
    public AxiosResult<Category> findById(@PathVariable Long id){
        return AxiosResult.success(categoryService.findById(id));
    }

    @PostMapping
    public AxiosResult<Void> addEntity(@RequestBody Category entity){
        return toAxios(categoryService.addEntity(entity));
    }

    @PutMapping
    public AxiosResult<Void> updateEntity(@RequestBody Category entity){
        int i = categoryService.updateEntity(entity);
        if (i > 0) {
            return AxiosResult.success();
        }else {
            return AxiosResult.error();
        }
    }

    @DeleteMapping("{ids}")
    public AxiosResult<Void> deleteById(@PathVariable List<Long> ids){
        return toAxios(categoryService.batchDeleteByIds(ids));
    }
}
