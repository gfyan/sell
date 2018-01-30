package com.gfy.sell.entity;

import com.gfy.sell.enumbean.OrderMasterOrderStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表实体类
 *
 * @author gfy
 */
@Data
@Entity
public class OrderMaster {


    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus = OrderMasterOrderStatusEnum.NEW.getCode();

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
                '}';
    }
}