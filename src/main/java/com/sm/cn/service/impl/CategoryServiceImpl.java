package com.sm.cn.service.impl;

import com.sm.cn.entity.Category;
import com.sm.cn.service.CategoryService;
import com.sm.cn.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<Category,Long> implements CategoryService {
}
