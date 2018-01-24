package com.gfy.sell.dao;

import com.gfy.sell.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;


    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("33344555");
        productInfo.setProductName("屁大瘦肉粥");
        productInfo.setProductDescription("这是买粥的");
        productInfo.setProductIcon("sdad");
        productInfo.setProductStatus(0);
        productInfo.setProductStock(1111);
        productInfo.setCategoryType(111);
        productInfo.setProductPrice(new BigDecimal(3.8));
        ProductInfo save = productInfoRepository.save(productInfo);
        Assert.assertNotEquals(null, save);
    }

    @Test
    public void updateTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("3123213213");
        productInfo.setProductName("屁大瘦肉粥1111");
        productInfo.setProductDescription("这是买粥的343333333");
        productInfo.setProductIcon("sdad");
        productInfo.setProductStatus(0);
        productInfo.setProductStock(1111);
        productInfo.setCategoryType(111);
        productInfo.setProductPrice(new BigDecimal(3.8));
        ProductInfo save = productInfoRepository.save(productInfo);
        Assert.assertNotEquals(null, save);
    }

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> byProductStatus = productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0, byProductStatus.size());

    }

}