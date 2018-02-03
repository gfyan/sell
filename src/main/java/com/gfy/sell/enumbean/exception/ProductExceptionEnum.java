package com.gfy.sell.enumbean.exception;

import lombok.Getter;

/**
 * @author gfy
 */
@Getter
public enum ProductExceptionEnum implements BaseExceptionEnum {

    /**
     * 商品不存在需要返回的信息
     */
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不正确"),
    PRODUCT_INSERT_ERROR(12, "商品信息保存失败");

    private Integer code;

    private String message;

    ProductExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
