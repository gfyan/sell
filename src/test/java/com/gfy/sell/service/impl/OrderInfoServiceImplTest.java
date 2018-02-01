package com.gfy.sell.service.impl;

import com.gfy.sell.dto.req.OrderInfoReqDto;
import com.gfy.sell.entity.OrderDetail;
import com.gfy.sell.service.OrderInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
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
    }

    @Test
    public void findList() throws Exception {
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