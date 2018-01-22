package com.gfy.sell.dao;

import com.gfy.sell.entity.OrderMaster;

public interface OrderMasterRepository {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    OrderMaster selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);
}