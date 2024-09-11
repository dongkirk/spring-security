/* Copyright © 2024 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.myspringsecurity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.myspringsecurity.dto.SysRole;
import com.example.myspringsecurity.dto.SysUser;

@Mapper
public interface SysUserMapper {
    List<SysRole> getRolesByUid(Integer id);
    SysUser loadUserByUsername(String username);

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(SysUser user);
}
