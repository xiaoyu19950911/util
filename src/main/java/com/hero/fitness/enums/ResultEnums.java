package com.hero.fitness.enums;

/**
 * @Author: xiaoyu
 * @Descripstion:
 * @Date:Created in 2018/2/1 14:58
 * @Modified By:
 */
public enum ResultEnums {

    UNKNOW_ERROR(-1,"未知错误!"),
    SUCCESS(100,"成功!"),
    PARAMETERS_ERROR(102,"参数错误!")
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

