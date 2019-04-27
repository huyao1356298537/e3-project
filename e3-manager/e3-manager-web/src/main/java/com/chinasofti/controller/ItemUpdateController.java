package com.chinasofti.controller;

import com.chinasofti.entity.TbItem;
import com.chinasofti.entity.TbItemDesc;
import com.chinasofti.service.ItemDescService;
import com.chinasofti.service.ItemService;
import com.chinasofti.util.E3Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * author:胡瑶
 * date:2019/4/24
 * time:14:53
 */
@Controller
@RequestMapping("/rest")
public class ItemUpdateController {
    @Autowired
    ItemService itemService;
    @Autowired
    ItemDescService itemDescService;
    @RequestMapping("/item/reshelf")
    @ResponseBody
    public E3Result reshelf(long... ids){
        for (long id :ids) {
            TbItem tbItem = itemService.quertOne(id);
            tbItem.setStatus((byte)1);
            System.out.println(tbItem.getStatus());
            itemService.update(tbItem);
        }
        return E3Result.ok();
    }
    @RequestMapping("/item/instock")
    @ResponseBody
    public E3Result instock(long... ids){
        for (long id :ids) {
            TbItem tbItem = itemService.quertOne(id);
            tbItem.setStatus((byte)2);
            System.out.println(tbItem.getStatus());
            itemService.update(tbItem);
        }
        return E3Result.ok();
    }
    @RequestMapping("/item/delete")
    @ResponseBody
    public E3Result delete(long... ids){
        for (long id :ids) {
            itemService.delete(id);
        }
        return E3Result.ok();
    }
    @RequestMapping("/page/item-edit")
    public String toUpdate(){
        return "item-edit";
    }
    @RequestMapping("/item/query/item/desc/{id}")
    @ResponseBody
    public E3Result query1(@PathVariable long id){
        TbItemDesc tbItemDesc = itemDescService.queryOne(id);
        return E3Result.ok(tbItemDesc);
    }
    //    @RequestMapping("/item/query/item/query/{id}")
//    @ResponseBody
//    public E3Result query2(@PathVariable long id){
//        TbItem tbItem = itemService.quertOne(id);
//        return E3Result.ok(tbItem);
//    }
    @RequestMapping("/item/update")
    @ResponseBody
    public E3Result update(TbItem tbItem,String desc){
        TbItem tbItem1 = itemService.quertOne(tbItem.getId());
        tbItem.setUpdated(new Date());
        tbItem.setCreated(tbItem1.getCreated());
        tbItem.setStatus((tbItem1.getStatus()));
        itemService.update(tbItem);
        TbItemDesc tbItemDesc = itemDescService.queryOne(tbItem.getId());
        tbItemDesc.setUpdated(new Date());
        tbItemDesc.setItemDesc(desc);
        itemDescService.update(tbItemDesc);
        return  E3Result.ok();
    }

}