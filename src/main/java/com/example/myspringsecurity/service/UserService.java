package com.example.myspringsecurity.service;/* Copyright © 2024 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

import java.util.List;

import com.example.myspringsecurity.dto.Role;
import com.example.myspringsecurity.dto.User;


public interface UserService {
    List<Role> getRolesByUid(Integer id);
    User loadUserByUsername(String username);
}
