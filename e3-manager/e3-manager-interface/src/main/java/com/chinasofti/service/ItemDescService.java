package com.chinasofti.service;

import com.chinasofti.entity.TbItemDesc;

/**
 * author:胡瑶
 * date:2019/4/25
 * time:18:36
 */
public interface ItemDescService {

    public void save(TbItemDesc tbItemDesc);
    public TbItemDesc queryOne(long id);
    public void update(TbItemDesc tbItemDesc);
}
