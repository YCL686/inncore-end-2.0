package com.inncore.beta.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 字典 实体
 * </p>
 *
 * @author ymm
 * @since 2021-03-04
 */
@ApiModel(value = "SysDict对象", description = "字典")
public class SysDict extends Model<SysDict> {
    private static final long serialVersionUID=1L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "名称")
    private String dictName;
    @ApiModelProperty(value = "编码")
    private String dictCode;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "排序（升序）")
    private Integer sort;
    @JsonIgnore
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @JsonIgnore
    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;
    @ApiModelProperty(value = "备注信息")
    private String remark;
    @ApiModelProperty(value = "删除标记")
    @TableLogic
    @JsonIgnore
    private Integer deleted;
    @ApiModelProperty(value = "租户Id")
    private String tenantId;

    public Integer getId(){
            return id;
            }

    public void setId(Integer id) {
            this.id = id;
            }

    public String getDictName(){
            return dictName;
            }

    public void setDictName(String dictName) {
            this.dictName = dictName;
            }

    public String getDictCode(){
            return dictCode;
            }

    public void setDictCode(String dictCode) {
            this.dictCode = dictCode;
            }

    public String getDescription(){
            return description;
            }

    public void setDescription(String description) {
            this.description = description;
            }

    public Integer getSort(){
            return sort;
            }

    public void setSort(Integer sort) {
            this.sort = sort;
            }

    public Date getCreatedTime(){
            return createdTime;
            }

    public void setCreatedTime(Date createdTime) {
            this.createdTime = createdTime;
            }

    public Date getUpdatedTime(){
            return updatedTime;
            }

    public void setUpdatedTime(Date updatedTime) {
            this.updatedTime = updatedTime;
            }

    public String getRemark(){
            return remark;
            }

    public void setRemark(String remark) {
            this.remark = remark;
            }

    public Integer getDeleted(){
            return deleted;
            }

    public void setDeleted(Integer deleted) {
            this.deleted = deleted;
            }

    public String getTenantId(){
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
        return "SysDict{" +
                "id=" + id +
                ", dictName=" + dictName +
                ", dictCode=" + dictCode +
                ", description=" + description +
                ", sort=" + sort +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", remark=" + remark +
                ", deleted=" + deleted +
                ", tenantId=" + tenantId +
        "}";
    }
}
