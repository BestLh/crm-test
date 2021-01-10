package com.sm.cn.controller.base;

import com.github.pagehelper.PageHelper;
import com.sm.cn.common.http.AxiosResult;
import com.sm.cn.entity.Brand;
import com.sm.cn.service.base.BaseService;
import com.sm.cn.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseController<T,ID> {
    public AxiosResult<Void> toAxios(int row){
        return row>0?AxiosResult.success():AxiosResult.success();
    }
}
