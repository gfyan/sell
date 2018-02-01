package com.gfy.sell.entity;

import com.gfy.sell.enumbean.table.OrderMasterOrderStatusEnum;
import com.gfy.sell.enumbean.table.OrderMasterPayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表实体类
 *
 * @author gfy
 */
@Data
@Entity
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    private String buyerOpenid;

    /**
     * 商品总价
     **/
    private BigDecimal orderAmount;

    private Integer orderStatus = OrderMasterOrderStatusEnum.NEW.getCode();

    private Integer payStatus = OrderMasterPayStatusEnum.WAIT.getCode();

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
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
                '}';
    }
}