package com.gfy.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gfy.sell.dto.resp.ProductInfoRespDto;
import lombok.Data;

import java.util.List;

/**
 * @author gfy
 */
@Data
public class ProductVo {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoRespDto> productInfoRespDtoList;

}
