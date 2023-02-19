package com.cloud.dao;

import com.cloud.pojo.Business;
import com.cloud.pojo.dto.BusinessDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusineDao {
    /**
     * 查询商家用户的接口
     */
    List<Business> getListBus(BusinessDto businessDto);

    /**
     * 商家注册接口
     */
    Integer setInsert(Business business);

    /**
     * 验证商家账号是否存在
     */
    String getSelCode(String bsCode);

    /**
     * 批量删除商家
     */
    Integer delBusAllId(List<Integer> listId);

    /**
     * 商家注销
     */
    Integer delBusId(Integer bsId);

    /**
     * 批量删除商家对应的信息接口
     */
    List getSelNum(List<Integer> listId);

    /**
     * 商家登录
     */
    Business LoginBus(@Param("bsCode")String bsCode,@Param("bsPaw")String bsPaw);
}
