/* Copyright © 2024 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.myspringsecurity.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myspringsecurity.service.impl.MyUserDetailsService;

@RestController
public class UserController {
    @Autowired
    MyUserDetailsService myUserDetailsService;

    @GetMapping("/user")
    public void userInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        System.out.println("name = " + name);
        System.out.println("authorities = " + authorities);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                if (authentication == null) {
                    System.out.println("获取用户信息失败");
                    return;
                }
                String name = authentication.getName();
                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + ":name = " + name);
                System.out.println(threadName + ":authorities = " + authorities);
            }
        }).start();
    }

    @GetMapping("/user_info")
    public UserDetails userDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return myUserDetailsService.loadUserByUsername(authentication.getName());
    }

}
