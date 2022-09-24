package com.notfound.crm.common.mapper;

import com.notfound.crm.common.base.Query;

import java.util.List;

/**
 * @Description:    Mapper基类，定义了部分常用的增、删、改、查方法
 */
public interface BaseMapper<F,V> {

    /**
     * 插入一条新信息
     * @param f
     * @return
     */
    int insert(F f);

    /**
     * 根据id删除信息
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 修改信息
     * @param f
     * @return
     */
    int update(F f);

    /**
     * 根据id查询一条数据
     * @param id
     * @return
     */
    V selectOne(Integer id);

    /**
     * 查询数据列表
     * @param query
     * @return
     */
    List<V>  selectList(Query query);
}
