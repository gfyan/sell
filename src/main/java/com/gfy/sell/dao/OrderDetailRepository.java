package com.gfy.sell.dao;

import com.gfy.sell.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单详细dao层
 *
 * @author gfy
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 按照订单id查询所有的订单详情
     *
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);

}