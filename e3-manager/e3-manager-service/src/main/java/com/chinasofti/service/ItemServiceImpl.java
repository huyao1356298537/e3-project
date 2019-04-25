package com.chinasofti.service;

import com.chinasofti.EasyUIDataGridResult;
import com.chinasofti.dao.ItemDao;
import com.chinasofti.entity.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:胡瑶
 * date:2019/4/24
 * time:14:59
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Override
    public EasyUIDataGridResult queryByPageBean(int pageIndex,int pageCount) {

        int first = (pageIndex-1)*pageCount;
        int max = pageCount;
        List<TbItem> list = itemDao.queryByPageBean(new TbItem(), first, max);
        Long counts = itemDao.getCounts();
        EasyUIDataGridResult easyUIDataGridResult  =  new EasyUIDataGridResult(counts,list);
        return easyUIDataGridResult;
    }
    @Override
    public void save(TbItem tbItem) {
        itemDao.add(tbItem);
    }

}

