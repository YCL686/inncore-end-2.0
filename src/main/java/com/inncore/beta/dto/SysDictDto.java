package com.inncore.beta.dto;

import com.inncore.beta.entity.SysDict;
import com.inncore.beta.entity.SysDictItem;

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
