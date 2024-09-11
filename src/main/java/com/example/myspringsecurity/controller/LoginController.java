/* Copyright © 2024 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.myspringsecurity.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Principal;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Producer;

@RestController
public class LoginController {
    @Autowired
    Producer producer;
    @GetMapping("/vc.jpg")
    public void getVerifyCode(HttpServletResponse resp, HttpSession session) throws IOException {
        resp.setContentType("image/jpeg");
        String text = producer.createText();
        session.setAttribute("kaptcha", text);
        BufferedImage image = producer.createImage(text);
        try(ServletOutputStream out = resp.getOutputStream()) {
            ImageIO.write(image, "jpg", out);
        }
    }

    @RequestMapping("/index")
    public String index() {
        return "login success";
    }
    @RequestMapping("/hello")
    public String hello() {
        return "hello spring security";
    }
    @RequestMapping("/authentication")
    public void authentication(Authentication authentication) {
        System.out.println("authentication = " + authentication);
    }
    @RequestMapping("/principal")
    public void principal(Principal principal, HttpServletRequest req) {
        System.out.println("req.getClass() = " + req.getClass());
        System.out.println("principal = " + principal);
    }
    @RequestMapping("/info")
    public void info(HttpServletRequest req) {
        String remoteUser = req.getRemoteUser();
        Authentication auth = ((Authentication) req.getUserPrincipal());
        boolean admin = req.isUserInRole("admin");
        System.out.println("remoteUser = " + remoteUser);
        System.out.println("auth.getName() = " + auth.getName());
        System.out.println("admin = " + admin);
    }
}
