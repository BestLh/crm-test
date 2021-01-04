package com.sm.cn.controller;

import com.sm.cn.controller.base.BaseController;
import com.sm.cn.entity.Brand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brand")
public class BrandController extends BaseController<Brand,Long> {
}
