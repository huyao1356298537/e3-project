package com.chinasofti.dao;

import com.chinasofti.framework.BaseDao;

import java.util.List;
/**
 * author:胡瑶
 * date:2019/4/25
 * time:11:12
 */
public interface ItemCatDao<TbItemCat> extends BaseDao<TbItemCat> {

    public List<TbItemCat> queryByPid(Integer pid);
}
