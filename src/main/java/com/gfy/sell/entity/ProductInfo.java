package com.gfy.sell.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品信息实体类
 *
 * @author gfy
 */
@Data
public class ProductInfo {
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @Override
    public String toString() {
        return "ProductInfo{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productStock=" + productStock +
                ", productDescription='" + productDescription + '\'' +
                ", productIcon='" + productIcon + '\'' +
                ", categoryType=" + categoryType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}