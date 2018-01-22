package com.gfy.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商品类目实体类
 *
 * @author gfy
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {


    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this();
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    /**
     * 类目主键
     */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    private Integer categoryType;

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }
}