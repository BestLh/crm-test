package com.sm.cn.service.base.impl;

import com.github.pagehelper.PageInfo;
import com.sm.cn.mapper.base.BaseMapper;
import com.sm.cn.service.base.BaseService;
import com.sm.cn.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BaseServiceImpl<T,ID> implements BaseService<T,ID> {
    @Autowired
    private BaseMapper<T,ID> baseMapper;

    @Override
    public BaseMapper<T,ID> getBaseMapper(){
        return baseMapper;
    }

    @Override
    public PageVo<T> findPage() {
        return setPageVo(baseMapper.selectByExample(null));
    }

    @Override
    public PageVo<T> findPage(Object example) {
        return setPageVo(baseMapper.selectByExample(example));
    }

    @Override
    public T findById(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addEntity(T entity) {
        return baseMapper.insert(entity);
    }

    @Override
    public int updateEntity(T entity) {
        return baseMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int deleteById(ID id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int batchAddEntity(List<T> list) {
        list.forEach(item -> baseMapper.insert(item));
        return 1;
    }

    @Transactional
    @Override
    public int batchUpdateEntity(List<T> list) {
        list.forEach(item -> baseMapper.updateByPrimaryKey(item));
        return 1;
    }

    @Transactional
    @Override
    public int batchDeleteByIds(List<ID> ids) {
        ids.forEach(item ->baseMapper.deleteByPrimaryKey(item));
        return 1;
    }

    @Override
    public PageVo<T> setPageVo(List<T> list) {
        PageInfo<T> pageInfo =new PageInfo<>(list);
        long total = pageInfo.getTotal();
        PageVo<T> pageVo = new PageVo<>();
        pageVo.setList(list);
        pageVo.setTotal(total);
        return pageVo;
    }
}
