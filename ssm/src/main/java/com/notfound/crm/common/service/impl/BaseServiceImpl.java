package com.notfound.crm.common.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.notfound.crm.common.service.IBaseService;
import com.notfound.crm.common.base.PageInfo;
import com.notfound.crm.common.base.Query;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.mapper.BaseMapper;
import com.notfound.crm.sys.domain.Fees;

import java.util.List;

/**
 * @Description: 服务层基类，实现了增加新数据，根据id删除数据，更新数据根据id查询数据，分页模糊查询等方法
 */
public class BaseServiceImpl<F> implements IBaseService<F> {

    private BaseMapper baseMapper;

    public BaseServiceImpl(BaseMapper baseMapper){this.baseMapper=baseMapper;}

    @Override
    public Result add(F f) {
        baseMapper.insert(f);
        return new Result();
    }

    @Override
    public Result delete(Integer id) {
        baseMapper.delete(id);
        return new Result();
    }

    @Override
    public Result update(F f) {
        baseMapper.update(f);
        return new Result();
    }

    @Override
    public Result query(Integer id) {
        Object data = baseMapper.selectOne(id);

        return new Result(data);
    }

    @Override
    public Result queryPage(Query query) {
        Page<Object> data = PageHelper.startPage(query.getCurrentPage(), query.getPageSize());

        List list = baseMapper.selectList(query);

        PageInfo pageData = new PageInfo(data.getPageNum(), data.getPageSize(), data.getTotal(), data.getResult());
        return new Result(pageData);
    }
}
