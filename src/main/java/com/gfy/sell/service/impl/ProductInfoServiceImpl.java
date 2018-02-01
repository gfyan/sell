package com.gfy.sell.service.impl;

import com.gfy.sell.dao.ProductInfoRepository;
import com.gfy.sell.entity.ProductInfo;
import com.gfy.sell.enumbean.table.ProductInfoProductStatusEnum;
import com.gfy.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gfy
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {


    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * 按照主键查询商品
     *
     * @param productId
     * @return
     */
    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findOne(productId);
    }

    /**
     * 按照分页查询商品
     *
     * @param pageable 分页参数
     * @return
     */
    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    /**
     * 查询所有在架的商品
     *
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductInfoProductStatusEnum.UP.getCode());
    }

    /**
     * 添加商品
     *
     * @param productInfo
     * @return
     */
    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }
}
