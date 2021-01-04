package com.sm.cn.service.impl;

import com.sm.cn.entity.Brand;
import com.sm.cn.service.BrandService;
import com.sm.cn.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrandServiceImpl extends BaseServiceImpl<Brand,Long> implements BrandService {
}
