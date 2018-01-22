package com.gfy.sell.dao;

import com.gfy.sell.entity.OrderDetail;

/**
 * @author gfy
 */
public interface OrderDetailRepository {

    int deleteByPrimaryKey(String detailId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String detailId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}