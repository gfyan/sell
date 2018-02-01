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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * @param orderInfoReqDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderInfoReqDto create(OrderInfoReqDto orderInfoReqDto) {

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        String orderId = KeyUtil.getUniqueKey();

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
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            BeanUtils.copyProperties(productInfo, orderDetail);
            try {
                orderDetailRepository.save(orderDetail);
            } catch (Exception e) {
                log.error("订单详情失败：" + orderDetail.toString());
                throw new SellException(OrderExceptionEnum.ORDER_INSERT_ERROR);
            }
        }


        //3.写入订单数据库
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        BeanUtils.copyProperties(orderInfoReqDto, orderMaster);
        try {
            orderMasterRepository.save(orderMaster);
        } catch (Exception e) {
            log.error("订单主信息插入失败：" + orderMaster.toString());
            throw new SellException(OrderExceptionEnum.ORDER_INSERT_ERROR);
        }


        //4.扣库存
        List<CartReqDto> cartReqDtoList = orderInfoReqDto.getOrderDetailList().stream().map(
                e -> new CartReqDto(e.getOrderId(), e.getProductQuantity())).
                collect(Collectors.toList());
        productInfoService.decreaseStock(cartReqDtoList);

        return orderInfoReqDto;
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
