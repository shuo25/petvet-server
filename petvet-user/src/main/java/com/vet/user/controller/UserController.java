package com.vet.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vet.resp.ResultData;
import com.vet.user.entity.User;
import com.vet.user.service.IUserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author petvet
 * @since 2024-07-14
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 分页获取所有用户信息
     * @param user 用户信息
     * @param pageNo 第几页
     * @param pageSize 每页有几条数据
     * @param request
     * */
    @GetMapping(value = "/page")
    public ResultData<?> getPageList(User user,
                                     @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                     @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                     HttpServletRequest request){
        Page<User> page = new Page<>(pageNo, pageSize);
        IPage<User> pageList = userService.page(page, new QueryWrapper<User>().lambda());
        return ResultData.success(pageList);
    }

    /**
     * 新增用户
     * */
    @PostMapping(value = "/save")
    public ResultData<?> saveData(@RequestBody User user){
        return userService.addData(user);
    }

    /**
     * 修改用户
     * */
    @PutMapping(value = "/update")
    public ResultData<?> updateData(@RequestBody User user){
        userService.updateById(user);
        return ResultData.success("修改成功");
    }

    /**
     * 删除用户
     * */
    @DeleteMapping(value = "/by_id")
    public ResultData<?> deleteById(@RequestParam(name = "id") String id){
        userService.removeById(id);
        return ResultData.success("删除成功");
    }

    /**
     * 根据id获取用户信息
     * @param id id
     * */
    @GetMapping(value = "/by_id")
    public ResultData<?> getUserById(@RequestParam String id){
        User user = userService.getById(id);
        return ResultData.success(user);
    }


}
