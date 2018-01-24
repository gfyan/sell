package com.gfy.sell.vo;

import lombok.Data;

/**
 * @author gfy
 */
@Data
public class ResultVo<T> {

    private Integer code;

    private T data;

    private String message;


}
