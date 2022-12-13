package com.test.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JsonResponseStatus {
    SUCCESS(200,"成功"),
    ERROR(100,"失败"),
    NULLACCOUNT(204,"账号不存在"),
    PWDERROR(205,"密码错误"),
    ACCOUNTEXISTS(201,"账号已存在"),
    CREATEMENUFAILE(1001,"菜单不存在"),
    SAVEERROR(301,"新增失败"),
    UPDATEERROR(302,"修改失败"),
    DELERROR(303,"删除失败"),
            ;

    private Integer code;
    private String msg;
}
