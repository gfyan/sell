package com.gfy.sell.dao;

import com.gfy.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品类目对应数据层
 *
 * @author gfy
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 按照类目类型列表进行查询所有类目信息
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}