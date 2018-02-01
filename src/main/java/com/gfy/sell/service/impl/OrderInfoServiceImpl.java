package com.gfy.sell.service.impl;

import com.gfy.sell.dao.OrderDetailRepository;
import com.gfy.sell.dao.OrderMasterRepository;
import com.gfy.sell.dto.req.OrderInfoReqDto;
import com.gfy.sell.dto.resp.OrderInfoRespDto;
import com.gfy.sell.entity.OrderDetail;
import com.gfy.sell.entity.ProductInfo;
import com.gfy.sell.enumbean.exception.OrderServiceExceptionEnum;
import com.gfy.sell.exception.SellException;
import com.gfy.sell.service.OrderInfoService;
import com.gfy.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 订单--service实现层
 *
 * @author gfy
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 创建订单
     *
     * @param orderInfoReqDto
     * @return
     */
    @Override
    public OrderInfoReqDto create(OrderInfoReqDto orderInfoReqDto) {

        BigDecimal bigDecimal = new BigDecimal(BigInteger.ZERO);

        //1.查询商品（用于创建订单详情）
        for (OrderDetail orderDetail : orderInfoReqDto.getOrderDetailList()) {
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getOrderId());
            if (productInfo == null) {
                throw new SellException(OrderServiceExceptionEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算总价

        }


        //3.写入订单数据库


        //4.扣库存


        return null;
    }

    @Override
    public OrderInfoRespDto findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderInfoRespDto> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderInfoReqDto cancel(OrderInfoReqDto orderInfoReqDto) {
        return null;
    }

    @Override
    public OrderInfoReqDto finish(OrderInfoReqDto orderInfoReqDto) {
        return null;
    }

    @Override
    public OrderInfoReqDto payOrder(OrderInfoReqDto orderInfoReqDto) {
        return null;
    }
}
