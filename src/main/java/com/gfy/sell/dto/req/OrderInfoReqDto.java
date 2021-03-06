package com.gfy.sell.dto.req;

import com.gfy.sell.entity.OrderDetail;
import com.gfy.sell.enumbean.table.OrderMasterOrderStatusEnum;
import com.gfy.sell.enumbean.table.OrderMasterPayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单各层传输对象
 *
 * @author gfy
 */
@Data
public class OrderInfoReqDto {
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

    private Integer orderStatus = OrderMasterOrderStatusEnum.NEW.getCode();

    private Integer payStatus = OrderMasterPayStatusEnum.WAIT.getCode();

    List<OrderDetail> orderDetailList;

}
