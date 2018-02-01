package com.gfy.sell.enumbean.exception;

/**
 * @author gfy
 */
public interface BaseExceptionEnum {

    /**
     * 获取错误信息code
     *
     * @return
     */
    public Integer getCode();

    /**
     * 获取错误信息详情
     *
     * @return
     */
    public String getMessage();


}
