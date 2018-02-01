package com.gfy.sell.dao;

import com.gfy.sell.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by gfyan on 2018/1/31.
 *
 * @author gfyan
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("桂方银");
        orderMaster.setBuyerPhone("18571652452");
        orderMaster.setBuyerAddress("蒋村");
        orderMaster.setBuyerOpenid("1110");
        orderMaster.setOrderAmount(new BigDecimal(1212.55));
        OrderMaster save = orderMasterRepository.save(orderMaster);
        Assert.assertNotEquals(null, save);
    }


    @Test
    public void updateTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("32132132");
        orderMaster.setBuyerName("桂方银22222");
        orderMaster.setBuyerPhone("18571652452");
        orderMaster.setBuyerAddress("蒋村");
        orderMaster.setBuyerOpenid("1110");
        orderMaster.setOrderAmount(new BigDecimal(1212.55));
        OrderMaster save = orderMasterRepository.save(orderMaster);
        Assert.assertNotEquals(null, save);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest pageRequest = new PageRequest(0, 3);
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid("1110", pageRequest);
        Assert.assertNotEquals(0, orderMasterPage.getContent().size());
        System.out.println(orderMasterPage);
    }

}