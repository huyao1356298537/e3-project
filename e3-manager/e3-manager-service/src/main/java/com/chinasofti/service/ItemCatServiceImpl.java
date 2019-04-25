package com.chinasofti.service;

import com.chinasofti.EasyUITreeNode;
import com.chinasofti.dao.ItemCatDao;
import com.chinasofti.entity.TbItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author:胡瑶
 * date:2019/4/25
 * time:11:12
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    ItemCatDao itemCatDao;


    @Override
    public List<EasyUITreeNode> queryAction(Integer p_id) {
        // 通过pid 拿到节点
        List<TbItemCat> list = itemCatDao.queryByPid(p_id);
        // 将节点放入TreeNode
        List<EasyUITreeNode> easyUITreeNodeList =  new ArrayList<>();
        for (TbItemCat cat:list) {
            EasyUITreeNode  easyUITreeNode  =  new EasyUITreeNode();
            easyUITreeNode.setId(cat.getId()); // 节点id
            easyUITreeNode.setText(cat.getName()); // 类目
            //如果是父类目(本就是打开的)所以就进行closed ，不是(本就是关闭的)所以就open
            easyUITreeNode.setState(cat.getIsParent()?"closed":"open");  //状态
            // 将节点加入集合中
            easyUITreeNodeList.add(easyUITreeNode);
        }
        return easyUITreeNodeList;
    }
}

