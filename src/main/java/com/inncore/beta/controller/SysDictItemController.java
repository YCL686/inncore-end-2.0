package com.inncore.beta.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inncore.beta.entity.SysDictItem;
import com.inncore.beta.service.SysDictItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 字典详情表 控制器
 * </p>
 *
 * @author ymm
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/sys-dict-item")
@Api(tags = "字典详情表")
public class SysDictItemController extends ApiController {
    private static Logger log = LoggerFactory.getLogger(SysDictItemController.class);

    @Autowired
    private SysDictItemService sysDictItemService;
    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param sysDictItem 查询实体
     * @return 分页数据
     */
    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "field", value = "排序字段"),
        @ApiImplicitParam(name = "order", value = "是否升序，默认升序")
    })
    @PostMapping
    public R selectAll(@ApiIgnore Page<SysDictItem> page, SysDictItem sysDictItem,@RequestParam(required = false) String field,@RequestParam(required = false) Boolean order){
        if(field!=null){
            field=StrUtil.toUnderlineCase(field);
            List<OrderItem> orderItems=(order==null||order)?OrderItem.ascs(field):OrderItem.descs(field);
            page.setOrders(orderItems);
        }
        page.setOptimizeCountSql(false);
        page.setSearchCount(false);
        LambdaQueryWrapper<SysDictItem> wrapper=new LambdaQueryWrapper<>();

        page.setTotal(sysDictItemService.count(wrapper));
        return success(sysDictItemService.page(page,wrapper));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "ID查询")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Integer id){
        return success(sysDictItemService.getById(id));
    }

    /**
     * 查询所有数据
     *
     * @param sysDictItem 实体对象
     * @return 所有数据
     */
    @ApiOperation(value = "列表查询")
    @GetMapping
    public R list(SysDictItem sysDictItem){
        LambdaQueryWrapper<SysDictItem> wrapper=new LambdaQueryWrapper<>(sysDictItem);
        return success(sysDictItemService.list(wrapper));
    }

    /**
     * 修改数据
     *
     * @param sysDictItem 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "新增修改")
    @PutMapping
    public R save(SysDictItem sysDictItem){
        return success(sysDictItemService.saveOrUpdate(sysDictItem));
    }

    /**
     * 删除数据
     *
     * @param idList 主键集合
     * @return 删除结果
     */
    @ApiOperation(value = "删除")
    @DeleteMapping
    public R delete(@RequestParam("ids") Integer[] idList){
        return success(sysDictItemService.removeByIds(Arrays.asList(idList)));
    }

}
