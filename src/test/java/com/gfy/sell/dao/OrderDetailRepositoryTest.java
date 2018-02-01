package com.gfy.sell.dao;

import com.gfy.sell.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("312321");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("3213213");
        orderDetail.setProductName("屁大瘦肉粥");
        orderDetail.setProductId("33344555");
        orderDetail.setProductPrice(new BigDecimal(3.80));
        orderDetail.setProductQuantity(11);
        OrderDetail save = orderDetailRepository.save(orderDetail);
        Assert.assertNotEquals(null, save);
    }

    @Test
    public void updateTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("312321");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("3213213");
        orderDetail.setProductName("屁大瘦肉粥");
        orderDetail.setProductId("33344555");
        orderDetail.setProductPrice(new BigDecimal(3.80));
        orderDetail.setProductQuantity(12);
        OrderDetail save = orderDetailRepository.save(orderDetail);
        Assert.assertNotEquals(null, save);
    }


    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId("123456");
        Assert.assertNotEquals(0, orderDetailList.size());
    }

}