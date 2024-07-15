package com.vet.permission.mapper;

import com.vet.permission.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统权限表 Mapper 接口
 * </p>
 *
 * @author petvet
 * @since 2024-07-15
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
