package com.sm.cn.entity;

import com.sm.cn.entity.base.BaseEntity;

import java.util.Date;

public class Category extends BaseEntity {

    private String categoryName;

    private String categoryDesc;

    private Long parentId;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc == null ? null : categoryDesc.trim();
    }
}