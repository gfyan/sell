package com.gfy.sell.service.impl;

import com.gfy.sell.entity.ProductCategory;
import com.gfy.sell.service.ProductCategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory one = productCategoryService.findOne(1);
        Assert.assertNotEquals(one, null);
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> all = productCategoryService.findAll();
        Assert.assertNotEquals(0, all.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<Integer> categoryTypeIn = new ArrayList<>();
        categoryTypeIn.add(1);
        categoryTypeIn.add(2);
        List<ProductCategory> byCategoryTypeIn = productCategoryService.findByCategoryTypeIn(categoryTypeIn);
        Assert.assertNotEquals(0, byCategoryTypeIn.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(1111);
        productCategory.setCategoryName("sasa飒飒是");
        ProductCategory save = productCategoryService.save(productCategory);
        Assert.assertNotEquals(null, save);
    }

}