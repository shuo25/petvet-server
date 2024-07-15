package com.vet.permission.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统权限表
 * </p>
 *
 * @author petvet
 * @since 2024-07-15
 */
@Getter
@Setter
@TableName("sys_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 菜单路径
     */
    private String url;

    /**
     * 菜单类型1普通菜单2按钮权限
     */
    private Byte permissionType;

    /**
     * 父菜单id
     */
    private String parentId;

    /**
     * 删除状态
     */
    @TableLogic
    private Integer delFlag;
}
