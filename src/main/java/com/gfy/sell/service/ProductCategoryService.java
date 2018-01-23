package com.gfy.sell.service;

import com.gfy.sell.entity.ProductCategory;

import java.util.List;

/**
 * 商品类目service接口层
 *
 * @author gfy
 */
public interface ProductCategoryService {

    /**
     * 查询类目信息
     *
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有的类目信息
     *
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 按照类目类型列表进行查询所有类目信息
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 保存类目方法
     *
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);

}
