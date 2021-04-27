package com.ymm.microservices.usercenter.dto;

import com.ymm.microservices.usercenter.entity.SysDict;
import com.ymm.microservices.usercenter.entity.SysDictItem;

import java.util.List;

public class SysDictDto extends SysDict {

    private List<SysDictItem> items;

    public List<SysDictItem> getItems() {
        return items;
    }

    public void setItems(List<SysDictItem> items) {
        this.items = items;
    }
}
