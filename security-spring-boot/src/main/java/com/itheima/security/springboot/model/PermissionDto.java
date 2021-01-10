package com.itheima.security.springboot.model;

import lombok.Data;

/**
 * 权限
 * Program Name: security-itheima
 * Created by yanlp on 2021-01-10
 *
 * @author yanlp
 * @version 1.0
 */
@Data
public class PermissionDto {
    private String id;
    private String code;
    private String description;
    private String url;
}
