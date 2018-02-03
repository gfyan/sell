package com.gfy.sell.service.impl;

import com.gfy.sell.dao.OrderDetailRepository;
import com.gfy.sell.dao.OrderMasterRepository;
import com.gfy.sell.dao.ProductInfoRepository;
import com.gfy.sell.dto.req.CartReqDto;
import com.gfy.sell.dto.req.OrderInfoReqDto;
import com.gfy.sell.dto.resp.OrderInfoRespDto;
import com.gfy.sell.entity.OrderDetail;
import com.gfy.sell.entity.OrderMaster;
import com.gfy.sell.entity.ProductInfo;
import com.gfy.sell.enumbean.exception.OrderExceptionEnum;
import com.gfy.sell.enumbean.exception.ProductExceptionEnum;
import com.gfy.sell.exception.SellException;
import com.gfy.sell.service.OrderInfoService;
import com.gfy.sell.service.ProductInfoService;
import com.gfy.sell.util.KeyUtil;
import com.gfy.sell.util.OrderMaster2OrderInfoRespDtoConverter;
import com.google.common.collect.Collections2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单--service实现层
 *
 * @author gfy
 */
@Service
@Slf4j
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 创建订单
     *
     * @param orderInfoReqDto 前端参数封装实例
     * @return 订单对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderInfoReqDto create(OrderInfoReqDto orderInfoReqDto) {

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        String orderId = KeyUtil.getUniqueKey();

        orderInfoReqDto.setOrderId(orderId);

        //1.查询商品（用于创建订单详情）
        for (OrderDetail orderDetail : orderInfoReqDto.getOrderDetailList()) {
            ProductInfo productInfo = productInfoRepository.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ProductExceptionEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算总价
            orderAmount = productInfo.getProductPrice().
                    multiply(BigDecimal.valueOf(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            //订单详情入库
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            try {
                orderDetailRepository.save(orderDetail);
            } catch (Exception e) {
                log.error("插入订单详情失败：" + orderDetail.toString());
                throw new SellException(OrderExceptionEnum.ORDER_INSERT_ERROR);
            }
        }


        //3.写入订单数据库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderInfoReqDto, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        try {
            orderMasterRepository.save(orderMaster);
        } catch (Exception e) {
            log.error("订单主信息插入失败：" + orderMaster.toString() + "：" + e);
            throw new SellException(OrderExceptionEnum.ORDER_INSERT_ERROR);
        }


        //4.扣库存
        List<CartReqDto> cartReqDtoList = orderInfoReqDto.getOrderDetailList().stream().map(
                e -> new CartReqDto(e.getProductId(), e.getProductQuantity())).
                collect(Collectors.toList());
        productInfoService.decreaseStock(cartReqDtoList);

        return orderInfoReqDto;
    }

    @Override
    public OrderInfoRespDto findOne(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findOne(orderId);
        if (orderMaster == null) {
            throw new SellException(OrderExceptionEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new SellException(OrderExceptionEnum.ORDER_DETAIL_NOT_EXIST);
        }
        OrderInfoRespDto respDto = new OrderInfoRespDto();
        BeanUtils.copyProperties(orderMaster, respDto);
        respDto.setOrderDetailList(orderDetailList);
        return respDto;
    }

    @Override
    public Page<OrderInfoRespDto> findList(String buyerOpenId, Pageable pageable) {
        Page<OrderMaster> byBuyerOpenid = orderMasterRepository.findByBuyerOpenid(buyerOpenId, pageable);
        List<OrderInfoRespDto> respDtoList = OrderMaster2OrderInfoRespDtoConverter.convert(byBuyerOpenid.getContent());
        Page<OrderInfoRespDto> infoRespDtoPage = new PageImpl<>(respDtoList, pageable, byBuyerOpenid.getTotalElements());
        return infoRespDtoPage;
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
