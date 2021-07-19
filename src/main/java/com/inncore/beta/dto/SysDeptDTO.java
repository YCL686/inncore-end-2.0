package com.inncore.beta.dto;

import com.inncore.beta.entity.SysDept;

public class SysDeptDTO extends SysDept {
    private Integer childNum;

    public Integer getChildNum() {
        return childNum;
    }

    public void setChildNum(Integer childNum) {
        this.childNum = childNum;
    }
}
