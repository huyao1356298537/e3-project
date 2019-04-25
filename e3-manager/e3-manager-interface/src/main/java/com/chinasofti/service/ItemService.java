package com.chinasofti.service;

import com.chinasofti.EasyUIDataGridResult;
import com.chinasofti.entity.TbItem;

/**
 * author:胡瑶
 * date:2019/4/24
 * time:14:58
 */
public interface ItemService {

    public EasyUIDataGridResult queryByPageBean(int pageIndex, int pageCount);
    public void save(TbItem tbItem);
}
