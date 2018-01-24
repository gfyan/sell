package com.gfy.sell.dao;

import com.gfy.sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gfy
 */
@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 按照商品的状态查询商品列表
     *
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);


}