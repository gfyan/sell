package com.gfy.sell.enumbean.exception;

import lombok.Getter;

/**
 * @author A
 */
@Getter
public enum OrderServiceExceptionEnum implements BaseExceptionEnum {

    PRODUCT_NOT_EXIST(10, "商品不存在"),;

    private Integer code;

    private String message;

    OrderServiceExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
