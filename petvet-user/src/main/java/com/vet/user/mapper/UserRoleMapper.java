package com.vet.user.mapper;

import com.vet.user.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户角色关联表 Mapper 接口
 * </p>
 *
 * @author petvet
 * @since 2024-07-15
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
