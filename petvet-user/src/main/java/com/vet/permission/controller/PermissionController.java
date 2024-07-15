package com.vet.permission.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vet.permission.entity.Permission;
import com.vet.permission.service.IPermissionService;
import com.vet.resp.ResultData;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 系统权限表 前端控制器
 * </p>
 *
 * @author petvet
 * @since 2024-07-15
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Resource
    private IPermissionService permissionService;

    /**
     * 分页获取所有权限信息
     * @param permission 权限信息
     * @param pageNo 第几页
     * @param pageSize 每页有几条数据
     * @param request 请求
     * */
    @GetMapping(value = "/page")
    public ResultData<?> getPageList(Permission permission,
                                     @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                     @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                     HttpServletRequest request){
        Page<Permission> page = new Page<>(pageNo, pageSize);
        IPage<Permission> pageList = permissionService.page(page, new QueryWrapper<Permission>().lambda());
        return ResultData.success(pageList);
    }

    /**
     * 新增权限
     * */
    @PostMapping(value = "/save")
    public ResultData<?> saveData(@RequestBody Permission permission){
        boolean save = permissionService.save(permission);
        return ResultData.success("添加成功");
    }

    /**
     * 修改权限
     * */
    @PutMapping(value = "/update")
    public ResultData<?> updateData(@RequestBody Permission permission){
        permissionService.updateById(permission);
        return ResultData.success("修改成功");
    }

    /**
     * 删除权限
     * */
    @DeleteMapping(value = "/by_id")
    public ResultData<?> deleteById(@RequestParam(name = "id") String id){
        permissionService.removeById(id);
        return ResultData.success("删除成功");
    }

    /**
     * 根据id获取权限信息
     * @param id id
     * */
    @GetMapping(value = "/by_id")
    public ResultData<?> getUserById(@RequestParam String id){
        Permission permission = permissionService.getById(id);
        return ResultData.success(permission);
    }
}
