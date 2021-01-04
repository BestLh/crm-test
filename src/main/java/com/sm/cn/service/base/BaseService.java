package com.sm.cn.service.base;

import com.sm.cn.vo.PageVo;

import java.util.List;

public interface BaseService<T, ID> {

    /**
     * 分页查询
     */
    PageVo<T> findPage();

    /**
     * 带条件的查询
     */
    PageVo<T> findPage(Object example);

    /**
     * 通过ID查询
     */
    T findById(ID id);

    /**
     *添加操作
     */
    int addEntity(T entity);

    /**
     * 修改
     */
    int updateEntity(T entity);

    /**
     * 删除
     */
    int deleteById(ID id);

    /**
     * 批量添加
     */
    int batchAddEntity(List<T> list);

    /**
     * 批量修改
     */
    int batchUpdateEntity(List<T> list);

    /**
     * 批量删除
     */
    int batchDeleteByIds(List<ID> ids);

    /**
     * 封装分页数据
     */
    PageVo<T> setPageVo(List<T> list);
}
