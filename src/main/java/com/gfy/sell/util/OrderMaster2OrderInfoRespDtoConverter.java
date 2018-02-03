package com.gfy.sell.util;

import com.gfy.sell.dto.resp.OrderInfoRespDto;
import com.gfy.sell.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gfyan
 */
public class OrderMaster2OrderInfoRespDtoConverter {

    public static OrderInfoRespDto convert(OrderMaster orderMaster) {
        OrderInfoRespDto respDto = new OrderInfoRespDto();
        BeanUtils.copyProperties(orderMaster, respDto);
        return respDto;
    }

    public static List<OrderInfoRespDto> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(
                e -> convert(e)
        ).collect(Collectors.toList());
    }
}
