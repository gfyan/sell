package com.gfy.sell.service.impl;

import com.gfy.sell.dto.req.OrderInfoReqDto;
import com.gfy.sell.dto.resp.OrderInfoRespDto;
import com.gfy.sell.entity.OrderDetail;
import com.gfy.sell.service.OrderInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderInfoServiceImplTest {

    @Autowired
    private OrderInfoService orderInfoService;

    @Test
    public void create() throws Exception {
        OrderInfoReqDto reqDto = new OrderInfoReqDto();
        List<OrderDetail> detailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456789");
        orderDetail.setProductQuantity(12);
        detailList.add(orderDetail);


        reqDto.setBuyerAddress("中节能");
        reqDto.setBuyerName("桂方银");
        reqDto.setBuyerPhone("18571652452");
        reqDto.setBuyerOpenid("dsadsadsad3213123");

        reqDto.setOrderDetailList(detailList);

        orderInfoService.create(reqDto);
    }

    @Test
    public void findOne() throws Exception {

        OrderInfoRespDto result = orderInfoService.findOne("1517666271680");
        log.info("【查询单个订单】result={}" + result);
        Assert.assertNotEquals(null, result);

    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderInfoRespDto> result = orderInfoService.findList("dsadsadsad3213123", request);
        log.info("【查询买家订单列表】 result{}" + result.getContent());
        Assert.assertNotEquals(0, result.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {
    }

    @Test
    public void finish() throws Exception {
    }

    @Test
    public void payOrder() throws Exception {
    }

}