package com.gfy.sell.dao;

import com.gfy.sell.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = productCategoryRepository.findOne(1);
        System.out.println(productCategory);
    }

    @Test
    public void updateTest() {
        ProductCategory productCategory = new ProductCategory("312321", 32111321);
        productCategory.setCategoryId(6);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void findCategoryTypeListTest() {
        List<Integer> categoryTypeList = new ArrayList<>();
        categoryTypeList.add(1);
        categoryTypeList.add(2);
        List<ProductCategory> byCategoryTypeIn = productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
        System.out.println(byCategoryTypeIn);
    }

}