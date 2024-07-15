package com.vet.role.service.impl;

import com.vet.role.entity.Role;
import com.vet.role.mapper.RoleMapper;
import com.vet.role.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author petvet
 * @since 2024-07-15
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
