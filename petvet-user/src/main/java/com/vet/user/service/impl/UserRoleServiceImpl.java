package com.vet.user.service.impl;

import com.vet.user.entity.UserRole;
import com.vet.user.mapper.UserRoleMapper;
import com.vet.user.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author petvet
 * @since 2024-07-15
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
