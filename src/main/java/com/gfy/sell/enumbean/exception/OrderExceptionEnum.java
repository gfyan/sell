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
    ORDER_INSERT_ERROR(100, "下单失败"),
    ORDER_DETAIL_INSERT_ERROR(101, "插入订单详情失败"),
    ORDER_NOT_EXIST(102, "订单不存在"),
    ORDER_DETAIL_NOT_EXIST(103, "订单详情不存在");

    private Integer code;

    private String message;

    OrderExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
