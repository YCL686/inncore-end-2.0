package com.ymm.microservices.usercenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 字典详情表 实体
 * </p>
 *
 * @author ymm
 * @since 2021-03-04
 */
@ApiModel(value = "SysDictItem对象", description = "字典详情表")
public class SysDictItem extends Model<SysDictItem> {
    private static final long serialVersionUID=1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "字典id")
    private Integer dictId;
    @ApiModelProperty(value = "字典项键")
    private String itemKey;
    @ApiModelProperty(value = "字典项值")
    private String itemValue;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "状态（1启用 0不启用）")
    private Integer status;
    private String tenantId;
    public Integer getId(){
            return id;
            }

    public void setId(Integer id) {
            this.id = id;
            }

    public Integer getDictId(){
            return dictId;
            }

    public void setDictId(Integer dictId) {
            this.dictId = dictId;
            }

    public String getItemKey(){
            return itemKey;
            }

    public void setItemKey(String itemKey) {
            this.itemKey = itemKey;
            }

    public String getItemValue(){
            return itemValue;
            }

    public void setItemValue(String itemValue) {
            this.itemValue = itemValue;
            }

    public String getDescription(){
            return description;
            }

    public void setDescription(String description) {
            this.description = description;
            }

    public Integer getStatus(){
            return status;
            }

    public void setStatus(Integer status) {
            this.status = status;
            }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    protected Serializable pkVal(){
        return this.id;
    }
    @Override
    public String toString() {
        return "SysDictItem{" +
                "id=" + id +
                ", dictId=" + dictId +
                ", itemKey=" + itemKey +
                ", itemValue=" + itemValue +
                ", description=" + description +
                ", status=" + status +
        "}";
    }
}
