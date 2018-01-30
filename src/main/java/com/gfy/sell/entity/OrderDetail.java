package com.gfy.sell.entity;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author gfy
 */
@Data
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    /**
     * 商品id
     **/
    private String productId;

    /**
     * 商品名字
     **/
    private String productName;

    /**
     * 商品单价
     **/
    private BigDecimal productPrice;

    /**
     * 商品数量
     **/
    private Integer productQuantity;

    private String productIcon;

    private Date createTime;

    private Date updateTime;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "detailId='" + detailId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productIcon='" + productIcon + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}