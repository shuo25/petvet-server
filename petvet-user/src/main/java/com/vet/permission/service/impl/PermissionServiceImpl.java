package com.vet.permission.service.impl;

import com.vet.permission.entity.Permission;
import com.vet.permission.mapper.PermissionMapper;
import com.vet.permission.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统权限表 服务实现类
 * </p>
 *
 * @author petvet
 * @since 2024-07-15
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
