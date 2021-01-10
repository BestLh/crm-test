package com.sm.cn.service;

import com.sm.cn.entity.Category;
import com.sm.cn.service.base.BaseService;

import java.util.List;

public interface CategoryService extends BaseService<Category,Long> {
    List<Category> getTreeData();
}
