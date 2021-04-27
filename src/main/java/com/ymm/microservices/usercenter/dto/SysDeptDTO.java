package com.ymm.microservices.usercenter.dto;

import com.ymm.microservices.usercenter.entity.SysDept;

public class SysDeptDTO extends SysDept {
    private Integer childNum;

    public Integer getChildNum() {
        return childNum;
    }

    public void setChildNum(Integer childNum) {
        this.childNum = childNum;
    }
}
