package com.gfy.sell.dto.req;

import lombok.Data;

/**
 * @author gfy
 */
@Data
public class CartReqDto {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 数量
     */
    private Integer productQuantity;

    public CartReqDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
