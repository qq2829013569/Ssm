package com.cloud.dao;

import com.cloud.pojo.Customer;
import com.cloud.pojo.dto.CustomerDto;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CustomerDao {

    /**
     * 用户注册的方法
     */
    Integer setInsert(Customer customer);

    /**
     * 条件查询所有用户的方法
     */
    List<Customer> getIdSelect(CustomerDto customerDto);

    /**
     * 查询用户账号
     */
    String getSelCode(String customerCode);

    /**
     * 单个或批量删除用户信息
     */
    Integer delCunList(List<Integer> listId);

    /**
     *用户自行注销的信息
     */
    Integer delCusId(Integer customerId);

    /**
     * 用户登录方法
     */
    Customer getLoginCus(@Param("customerCode") String customerCode,@Param("customerPaw") String customerPaw);

}
