package com.gfy.sell.enumbean.exception;

import lombok.Getter;

/**
 * @author A
 */
@Getter
public enum OrderExceptionEnum implements BaseExceptionEnum {

    /**
     * 下单失败需要返回的信息
     */
    ORDER_INSERT_ERROR(100, "下单失败失败"),;

    private Integer code;

    private String message;

    OrderExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
