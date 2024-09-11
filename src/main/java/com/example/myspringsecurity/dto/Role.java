/* Copyright © 2024 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.example.myspringsecurity.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Role {
    private Integer role_id;
    private String role_name;
    private String role_key;
    private Integer role_sort;
    private String data_scope;
    private String status;
    private String del_flag;
    private String create_by;
    private Date create_time;
    private String update_by;
    private Date update_time;
    private String remark;
}
