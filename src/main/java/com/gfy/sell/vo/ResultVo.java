package com.gfy.sell.vo;

import lombok.Data;

import java.util.List;

/**
 * @author gfy
 */
@Data
public class ResultVo<T> {

    private Integer code;

    private T data;

    private String message;


    public static int SUCCESS_CODE = 0;


    public static ResultVo success(Object data) {
        ResultVo resultVo = new ResultVo<>();
        resultVo.setCode(SUCCESS_CODE);
        resultVo.setData(data);
        resultVo.setMessage("数据获取成功！");
        return resultVo;
    }

    public static ResultVo success(String message) {
        ResultVo resultVo = new ResultVo<>();
        resultVo.setCode(SUCCESS_CODE);
        resultVo.setMessage(message);
        return resultVo;
    }

    public static ResultVo error(Integer code, String message) {
        ResultVo resultVo = new ResultVo<>();
        resultVo.setCode(code);
        resultVo.setMessage(message);
        return resultVo;
    }


}
