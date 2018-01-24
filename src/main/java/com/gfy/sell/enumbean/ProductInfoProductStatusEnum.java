package com.gfy.sell.enumbean;

import lombok.Getter;

/**
 * @author gfy
 */
@Getter
public enum ProductInfoProductStatusEnum {

    UP(0, "上架"), DOWN(2, "下架");

    private Integer code;

    private String desc;

    ProductInfoProductStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
