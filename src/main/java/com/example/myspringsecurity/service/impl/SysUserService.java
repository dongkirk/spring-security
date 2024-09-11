/* Copyright © 2024 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.myspringsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myspringsecurity.dto.SysUser;
import com.example.myspringsecurity.mapper.SysUserMapper;

@Service
public class SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;
    public int insertUser(SysUser user)
    {
        // 新增用户信息
        int rows = sysUserMapper.insertUser(user);

//        // 新增用户岗位关联
//        insertUserPost(user);
//        // 新增用户与角色管理
//        insertUserRole(user);
        return rows;
    }
}
