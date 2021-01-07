package com.sm.cn.controller;

import com.sm.cn.controller.base.BaseController;
import com.sm.cn.entity.Supplier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("supplier")
public class SupplierController extends BaseController<Supplier,Long> {
}
