package com.sm.cn.service.impl;

import com.sm.cn.entity.Category;
import com.sm.cn.mapper.CategoryMapper;
import com.sm.cn.service.CategoryService;
import com.sm.cn.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<Category,Long> implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getTreeData() {
        List<Category> categories = categoryMapper.selectByExample(null);
        List<Category> root = categories.stream().filter(category -> category.getParentId().equals(0L)).collect(Collectors.toList());
        root.forEach(item->{
            getChildren(categories,item);
        });
        return root;
    }

    public void getChildren(List<Category> categories,Category category){
        List<Category> childrenList = categories.stream().filter(item -> item.getParentId().equals(category.getId())).collect(Collectors.toList());
        if (childrenList.size() > 0) {
            category.setChildren(childrenList);
            childrenList.forEach(item->{
                getChildren(categories,item);
            });
        }
    }
}
