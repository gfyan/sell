package com.gfy.sell.service.impl;

import com.gfy.sell.dao.ProductInfoRepository;
import com.gfy.sell.dto.req.CartReqDto;
import com.gfy.sell.entity.ProductInfo;
import com.gfy.sell.enumbean.exception.OrderExceptionEnum;
import com.gfy.sell.enumbean.exception.ProductExceptionEnum;
import com.gfy.sell.enumbean.table.ProductInfoProductStatusEnum;
import com.gfy.sell.exception.SellException;
import com.gfy.sell.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gfy
 */
@Service
@Slf4j
public class ProductInfoServiceImpl implements ProductInfoService {


    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * 按照主键查询商品
     *
     * @param productId 商品id
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
     * @param productInfo 商品javaBean
     * @return
     */
    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }


    /**
     * 加库存
     *
     * @param cartReqDtoList 购物车实例List
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void increaseStock(List<CartReqDto> cartReqDtoList) {
        for (CartReqDto cartReqDto : cartReqDtoList) {
            ProductInfo productInfo = productInfoRepository.findOne(cartReqDto.getProductId());
            if (productInfo == null) {
                throw new SellException(ProductExceptionEnum.PRODUCT_NOT_EXIST);
            }
            Integer surplus = productInfo.getProductStock() + cartReqDto.getProductQuantity();
            productInfo.setProductStock(surplus);
            try {
                productInfoRepository.save(productInfo);
            } catch (Exception e) {
                log.error("商品库存增加信息保存失败：{}", e);
                throw new SellException(OrderExceptionEnum.ORDER_DETAIL_INSERT_ERROR);
            }
        }

    }

    /**
     * 减库存
     *
     * @param cartReqDtoList 购物车实例List
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseStock(List<CartReqDto> cartReqDtoList) {
        for (CartReqDto cartReqDto : cartReqDtoList) {
            ProductInfo productInfo = productInfoRepository.findOne(cartReqDto.getProductId());
            if (productInfo == null) {
                throw new SellException(ProductExceptionEnum.PRODUCT_NOT_EXIST);
            }
            Integer surplus = productInfo.getProductStock() - cartReqDto.getProductQuantity();
            if (surplus < 0) {
                throw new SellException(ProductExceptionEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(surplus);
            try {
                productInfoRepository.save(productInfo);
            } catch (Exception e) {
                log.error("保存新库存信息失败：" + e);
                throw new SellException(ProductExceptionEnum.PRODUCT_INSERT_ERROR);
            }
        }
    }
}
