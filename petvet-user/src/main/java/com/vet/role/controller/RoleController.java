package com.vet.role.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vet.resp.ResultData;
import com.vet.role.entity.Role;
import com.vet.role.service.IRoleService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 系统角色表 前端控制器
 * </p>
 *
 * @author petvet
 * @since 2024-07-15
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource
    private IRoleService roleService;

    /**
     * 分页获取所有角色信息
     * @param role 角色信息
     * @param pageNo 第几页
     * @param pageSize 每页有几条数据
     * @param request
     * */
    @GetMapping(value = "/page")
    public ResultData<?> getPageList(Role role,
                                     @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                     @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                     HttpServletRequest request){
        Page<Role> page = new Page<>(pageNo, pageSize);
        IPage<Role> pageList = roleService.page(page, new QueryWrapper<Role>().lambda());
        return ResultData.success(pageList);
    }
    /**
     * 新增角色
     * */
    @PostMapping(value = "/save")
    public ResultData<?> saveData(@RequestBody Role role){
        boolean save = roleService.save(role);
        return ResultData.success("添加成功");
    }

    /**
     * 修改角色
     * */
    @PutMapping(value = "/update")
    public ResultData<?> updateData(@RequestBody Role role){
        roleService.updateById(role);
        return ResultData.success("修改成功");
    }

    /**
     * 删除角色
     * */
    @DeleteMapping(value = "/by_id")
    public ResultData<?> deleteById(@RequestParam(name = "id") String id){
        roleService.removeById(id);
        return ResultData.success("删除成功");
    }

    /**
     * 根据id获取角色信息
     * @param id id
     * */
    @GetMapping(value = "/by_id")
    public ResultData<?> getUserById(@RequestParam String id){
        Role role = roleService.getById(id);
        return ResultData.success(role);
    }
}
