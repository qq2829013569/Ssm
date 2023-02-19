package com.cloud.dao;

import com.cloud.pojo.Rider;
import com.cloud.pojo.dto.RiderDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RiderDao {
    /**
     * 骑手注册接口
     */
    Integer setInsert(Rider rider);

    /**
     *骑手查询接口
     */
    List<Rider> getListRider(RiderDto riderDto);

    /**
     * 骑手登录接口
     */
    Rider getLogin(@Param("riderCode")String riderCode,@Param("riderPaw")String riderPaw);

    /**
     * 骑手批量删除接口
     */
    Integer delListId(List<Integer> listId);

    /**
     * 骑手注销的接口
     */
    Integer delRiderId(Integer riderId);

    /**
     * 验证骑手账号是否存在
     */
    String getRiderCode(@Param("riderCode") String riderCode);
}
