package com.vet.user.service;

import com.vet.resp.ResultData;
import com.vet.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author petvet
 * @since 2024-07-14
 */
public interface IUserService extends IService<User> {

    User findByAccount(String username);

    ResultData<?> addData(User user);
}
