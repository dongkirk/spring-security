/* Copyright © 2024 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.myspringsecurity.dto;

import java.util.Date;
import java.util.List;

import com.example.myspringsecurity.vo.BaseEntity;

import lombok.Data;

@Data
public class SysUser extends BaseEntity {
    public static final long serialVersionUID = 1L;

    /** 用户ID */
    public Long userId;

    /** 部门ID */
    public Long deptId;

    /** 用户账号 */
    public String userName;

    /** 用户昵称 */
    public String nickName;

    /** 用户邮箱 */
    public String email;

    /** 手机号码 */
    public String phonenumber;

    /** 用户性别 */
    public String sex;

    /** 用户头像 */
    public String avatar;

    /** 密码 */
    public String password;

    /** 帐号状态（0正常 1停用） */
    public String status;

    /** 删除标志（0代表存在 2代表删除） */
    public String delFlag;

    /** 最后登录IP */
    public String loginIp;

    /** 最后登录时间 */
    public Date loginDate;

    /** 部门对象 */
    public SysDept dept;

    /** 角色对象 */
    public List<SysRole> roles;

    /** 角色组 */
    public Long[] roleIds;

    /** 岗位组 */
    public Long[] postIds;

    /** 角色ID */
    public Long roleId;

    /**
     * 累计收益
     */
    public Float countGain;

    /**
     * 可提现金额
     */
    public Float allowReflect;
}
