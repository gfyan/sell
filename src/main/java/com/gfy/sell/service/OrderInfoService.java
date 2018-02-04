package com.gfy.sell.service;

import com.gfy.sell.dto.req.OrderInfoReqDto;
import com.gfy.sell.dto.resp.OrderInfoRespDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 订单---service层
 *
 * @author gfy
 */
public interface OrderInfoService {

    /**
     * 创建订单
     *
     * @param orderInfoReqDto 前端参数
     * @return
     */
    OrderInfoReqDto create(OrderInfoReqDto orderInfoReqDto);

    /**
     * 查询单个订单对象
     *
     * @param orderId 订单id
     * @return
     */
    OrderInfoRespDto findOne(String orderId);

    /**
     * 查询订单列表
     *
     * @param buyerOpenId 买家openid
     * @param pageable    分页参数
     * @return
     */
    Page<OrderInfoRespDto> findList(String buyerOpenId, Pageable pageable);

    /**
     * 取消订单
     *
     * @param orderInfoReqDto 订单dto
     * @return 订单dto
     */
    OrderInfoReqDto cancel(OrderInfoReqDto orderInfoReqDto);

    /**
     * 完成订单
     *
     * @param orderInfoReqDto 订单bean
     * @return
     */
    OrderInfoReqDto finish(OrderInfoReqDto orderInfoReqDto);

    /**
     * 支付订单
     *
     * @param orderInfoReqDto
     * @return
     */
    OrderInfoReqDto payOrder(OrderInfoReqDto orderInfoReqDto);

}
