package com.vet.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vet.resp.ResultData;
import com.vet.user.entity.User;
import com.vet.user.mapper.UserMapper;
import com.vet.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author petvet
 * @since 2024-07-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public User findByAccount(String username) {
        List<User> userList = baseMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getUsername, username).eq(User::getDelFlag, 0));
        if (!userList.isEmpty()){
            return userList.get(0);
        }
        return null;
    }
    @Override
    public ResultData<?> addData(User user) {
        /*判断该账号是否存在*/
        if(this.findByAccount(user.getUsername()) != null){
            log.error(user.getUsername() + "已经存在！");
        }
        baseMapper.insert(user);
        return ResultData.success(user);
    }
}
