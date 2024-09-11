/* Copyright © 2024 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.myspringsecurity.dto;

import java.util.Set;

import lombok.Data;

@Data
public class SysRole {
    public static final long serialVersionUID = 1L;

    /** 角色ID */
    public Long roleId;

    /** 角色名称 */
    public String roleName;

    /** 角色权限 */
    public String roleKey;

    /** 角色排序 */
    public Integer roleSort;

    /** 数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限） */
    public String dataScope;

    /** 菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示） */
    public boolean menuCheckStrictly;

    /** 部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ） */
    public boolean deptCheckStrictly;

    /** 角色状态（0正常 1停用） */
    public String status;

    /** 删除标志（0代表存在 2代表删除） */
    public String delFlag;

    /** 用户是否存在此角色标识 默认不存在 */
    public boolean flag = false;

    /** 菜单组 */
    public Long[] menuIds;

    /** 部门组（数据权限） */
    public Long[] deptIds;

    /** 角色菜单权限 */
    public Set<String> permissions;
}
