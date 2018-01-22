package com.gfy.sell.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表实体类
 *
 * @author gfy
 */
@Data
public class OrderMaster {
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Byte orderStatus;

    private Date createTime;

    private Date updateTime;

    @Override
    public String toString() {
        return "OrderMaster{" +
                "orderId='" + orderId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", buyerPhone='" + buyerPhone + '\'' +
                ", buyerAddress='" + buyerAddress + '\'' +
                ", buyerOpenid='" + buyerOpenid + '\'' +
                ", orderAmount=" + orderAmount +
                ", orderStatus=" + orderStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}