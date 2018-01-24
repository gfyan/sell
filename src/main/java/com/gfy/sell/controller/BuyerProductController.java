package com.gfy.sell.controller;

import com.gfy.sell.dto.resp.ProductInfoRespDto;
import com.gfy.sell.entity.ProductCategory;
import com.gfy.sell.entity.ProductInfo;
import com.gfy.sell.service.ProductCategoryService;
import com.gfy.sell.service.ProductInfoService;
import com.gfy.sell.vo.ProductVo;
import com.gfy.sell.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gfy
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping(value = "/list")
    public ResultVo list() {
        //查询所有的商品
        List<ProductInfo> productInfoUpAll = productInfoService.findUpAll();

        //获取上架商品的所有类目列表
        List<Integer> categoryTypeList = productInfoUpAll.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        //按照类目列表进行查询出类目详细信息
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //查询所有的类目
        List<ProductCategory> categoryAll = productCategoryService.findAll();


        ProductInfoRespDto respDto = new ProductInfoRespDto();
        ProductVo productVo = new ProductVo();
        productVo.setProductInfoRespDtoList(Arrays.asList(respDto));
        ResultVo<ProductVo> resultVo = new ResultVo<>();
        resultVo.setData(productVo);
        return resultVo;
    }

}
