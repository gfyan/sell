package com.gfy.sell.service.impl;

import com.gfy.sell.entity.ProductInfo;
import com.gfy.sell.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findOne() throws Exception {
        ProductInfo one = productInfoService.findOne("33344555");
        Assert.assertEquals("33344555", one.getProductId());
    }

    @Test
    public void findAll() throws Exception {
        Pageable pageable = new PageRequest(0, 2);
        Page<ProductInfo> all = productInfoService.findAll(pageable);
        Assert.assertEquals(2, all.getSize());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> upAll = productInfoService.findUpAll();
        Assert.assertNotEquals(0, upAll.size());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456789");
        productInfo.setProductName("屁大瘦肉粥123456");
        productInfo.setProductDescription("这是买粥的123456");
        productInfo.setProductIcon("sdad");
        productInfo.setProductStatus(0);
        productInfo.setProductStock(1111);
        productInfo.setCategoryType(111);
        productInfo.setProductPrice(new BigDecimal(11.5));
        ProductInfo save = productInfoService.save(productInfo);
        Assert.assertNotEquals(null, save);
    }

}