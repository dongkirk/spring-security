/* Copyright © 2024 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.myspringsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.myspringsecurity.handler.MyAuthenticationFailureHandler;
import com.example.myspringsecurity.service.impl.MyUserDetailsService;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailsService myUserDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        ProviderManager manager = new ProviderManager(new KaptchaAuthenticationProvider());
        return manager;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/vc.jpg").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/mylogin.html")
            .loginProcessingUrl("/doLogin")
            .defaultSuccessUrl("/index.html")
            .failureHandler(new MyAuthenticationFailureHandler())
            .usernameParameter("uname")
            .passwordParameter("passwd")
            .permitAll()
            .and()
            .csrf().disable();
    }
}