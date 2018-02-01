package com.gfy.sell.enumbean.table;

import lombok.Getter;

/**
 * 订单状态枚举类
 *
 * @author gfy
 */
@Getter
public enum OrderMasterOrderStatusEnum {

    NEW(0, "新订单"), FINISHED(1, "支付完成"), CANCEL(2, "已取消");


    private Integer code;

    private String desc;


    OrderMasterOrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
