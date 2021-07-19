package com.inncore.beta.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inncore.beta.entity.SysDict;
import com.inncore.beta.service.SysDictService;
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
 * 字典 控制器
 * </p>
 *
 * @author ymm
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/sys-dict")
@Api(tags = "字典")
public class SysDictController extends ApiController {
    private static Logger log = LoggerFactory.getLogger(SysDictController.class);

    @Autowired
    private SysDictService sysDictService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param sysDict 查询实体
     * @return 分页数据
     */
    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "field", value = "排序字段"),
        @ApiImplicitParam(name = "order", value = "是否升序，默认升序")
    })
    @PostMapping
    public R selectAll(@ApiIgnore Page<SysDict> page, SysDict sysDict,@RequestParam(required = false) String field,@RequestParam(required = false) Boolean order){
        if(field!=null){
            field=StrUtil.toUnderlineCase(field);
            List<OrderItem> orderItems=(order==null||order)?OrderItem.ascs(field):OrderItem.descs(field);
            page.setOrders(orderItems);
        }
        page.setOptimizeCountSql(false);
        page.setSearchCount(false);
        QueryWrapper<SysDict> wrapper=new QueryWrapper<>();
        if(StrUtil.isNotEmpty(sysDict.getDictName())) {
            wrapper.like("sys_dict.dict_name", sysDict.getDictName());
        }
        wrapper.eq("sys_dict.deleted", 0);
        page.setTotal(sysDictService.countSysDictDto(wrapper));
        return success(sysDictService.pageSysDictDto(page,wrapper));
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
        return success(sysDictService.getById(id));
    }

    /**
     * 查询所有数据
     *
     * @param sysDict 实体对象
     * @return 所有数据
     */
    @ApiOperation(value = "列表查询")
    @GetMapping
    public R list(SysDict sysDict){
        LambdaQueryWrapper<SysDict> wrapper=new LambdaQueryWrapper<>(sysDict);
        return success(sysDictService.list(wrapper));
    }

    /**
     * 修改数据
     *
     * @param sysDict 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "新增修改")
    @PutMapping
    public R save(SysDict sysDict){
        return success(sysDictService.saveOrUpdate(sysDict));
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
        return success(sysDictService.removeByIds(Arrays.asList(idList)));
    }

    /**
     * 通过dictCode查询单条数据
     *
     * @param code
     * @return 单条数据
     */
    @ApiOperation(value = "code查询")
    @GetMapping("/dict/{code}")
    public R selectOne(@PathVariable String code){
        LambdaQueryWrapper<SysDict> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysDict::getDictCode, code);
        wrapper.eq(SysDict::getDeleted, 0);
        return success(sysDictService.getDto(wrapper));
    }


}
