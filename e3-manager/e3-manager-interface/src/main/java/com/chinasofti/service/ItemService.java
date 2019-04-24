package com.chinasofti.service;

import com.chinasofti.EasyUIDataGridResult;

/**
 * author:胡瑶
 * date:2019/4/24
 * time:14:53
 */
public interface ItemService {

    public EasyUIDataGridResult queryByPageBean(int pageIndex, int pageCount);
}
