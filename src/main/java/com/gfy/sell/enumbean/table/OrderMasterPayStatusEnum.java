package com.gfy.sell.enumbean.table;

import lombok.Getter;

/**
 * 订单支付状态枚举类
 *
 * @author gfy
 */
@Getter
public enum OrderMasterPayStatusEnum {

    WAIT(0, "未支付"), SUCCESS(1, "支付成功");

    private int code;

    private String desc;

    OrderMasterPayStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
