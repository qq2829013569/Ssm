package com.cloud.server;

import com.cloud.pojo.Business;
import com.cloud.pojo.CommonResult;
import com.cloud.pojo.dto.BusinessDto;

import java.util.List;

public interface BusinessServer {

    CommonResult getListBus(BusinessDto businessDto);

    CommonResult setInsert(Business business);


    CommonResult delBusAllId(List<Integer> listId);

    CommonResult delBusId(Integer bsId);

    CommonResult getSelNum(List<Integer> listId);

    CommonResult LoginBus(String bsCode,String bsPaw);
}
