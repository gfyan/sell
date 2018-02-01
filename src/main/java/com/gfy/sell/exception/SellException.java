package com.gfy.sell.exception;

import com.gfy.sell.enumbean.exception.BaseExceptionEnum;

/**
 * 业务级异常
 *
 * @author gfy
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(BaseExceptionEnum baseExceptionEnum) {
        super(baseExceptionEnum.getMessage());
        code = baseExceptionEnum.getCode();
    }
}
