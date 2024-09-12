/* Copyright © 2024 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.myspringsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myspringsecurity.common.utils.SecurityUtils;
import com.example.myspringsecurity.dto.SysUser;
import com.example.myspringsecurity.service.impl.SysUserService;
import com.example.myspringsecurity.vo.AjaxResult;

@RestController
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysUser user)
    {
//        if (!userService.checkUserNameUnique(user))
//        {
//            return error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
//        }
//        else if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user))
//        {
//            return error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
//        }
//        else if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user))
//        {
//            return error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
//        }
        user.setCreateBy("admin");
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        //return toAjax(userService.insertUser(user));

        return null;
    }
}
