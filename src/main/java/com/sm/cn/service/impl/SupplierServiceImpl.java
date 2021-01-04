package com.sm.cn.service.impl;

import com.sm.cn.entity.Supplier;
import com.sm.cn.service.SupplierService;
import com.sm.cn.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SupplierServiceImpl extends BaseServiceImpl<Supplier,Long> implements SupplierService {
}
