package com.gfy.sell.controller;

import com.gfy.sell.dto.resp.ProductInfoRespDto;
import com.gfy.sell.entity.ProductCategory;
import com.gfy.sell.entity.ProductInfo;
import com.gfy.sell.service.ProductCategoryService;
import com.gfy.sell.service.ProductInfoService;
import com.gfy.sell.vo.ProductVo;
import com.gfy.sell.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

        List<ProductInfo> tempProductInfoList = new ArrayList<>();
        List<ProductVo> productVoList = new ArrayList<>();
        //遍历所有类目
        for (ProductCategory entity : productCategoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(entity.getCategoryName());
            productVo.setCategoryType(entity.getCategoryType());

            //遍历类目下的商品
            List<ProductInfoRespDto> respDtoList = new ArrayList<>();
            for (ProductInfo entity2 : productInfoUpAll) {
                if (entity2.getCategoryType().equals(entity.getCategoryType())) {
                    ProductInfoRespDto respDto = new ProductInfoRespDto();
                    BeanUtils.copyProperties(entity2, respDto);
                    respDtoList.add(respDto);
                    tempProductInfoList.add(entity2);
                }
            }

            //移除已经添加过的商品
            productInfoUpAll.removeAll(tempProductInfoList);
            tempProductInfoList.clear();
            productVo.setProductInfoRespDtoList(respDtoList);
            productVoList.add(productVo);
        }

        //返回json数据
        return ResultVo.success(productVoList);
    }

}
