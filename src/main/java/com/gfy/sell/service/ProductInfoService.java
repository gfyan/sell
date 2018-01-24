package com.gfy.sell.service;

import com.gfy.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author gfy
 */
public interface ProductInfoService {

    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有的商品信息
     *
     * @param pageable 分页参数
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 按照类目类型列表进行查询所有商品信息
     *
     * @return
     */
    List<ProductInfo> findUpAll();


    //加库存


    //减库存

    /**
     * 保存商品方法
     *
     * @param ProductInfo
     * @return
     */
    ProductInfo save(ProductInfo ProductInfo);

}
