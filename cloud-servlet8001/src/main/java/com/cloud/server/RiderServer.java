package com.cloud.server;

import com.cloud.pojo.CommonResult;
import com.cloud.pojo.Rider;
import com.cloud.pojo.dto.RiderDto;

import java.util.List;

public interface RiderServer {

    CommonResult setInsert(Rider rider);

    CommonResult getListRider(RiderDto riderDto);

    CommonResult getLogin(String riderCode,String riderPaw);

    CommonResult delListId(List<Integer> listId);

    CommonResult delRiderId(Integer riderId);

}
