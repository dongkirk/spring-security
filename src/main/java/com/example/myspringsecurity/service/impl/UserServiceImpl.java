/* Copyright © 2024 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.myspringsecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myspringsecurity.dto.Role;
import com.example.myspringsecurity.dto.User;
import com.example.myspringsecurity.mapper.UserMapper;
import com.example.myspringsecurity.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public List<Role> getRolesByUid(Integer id) {
        return userMapper.getRolesByUid(id);
    }

    public User loadUserByUsername(String username) {
        return userMapper.loadUserByUsername(username);
    }
}
