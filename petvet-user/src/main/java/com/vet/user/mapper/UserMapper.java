package com.vet.user.mapper;

import com.vet.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author petvet
 * @since 2024-07-14
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
