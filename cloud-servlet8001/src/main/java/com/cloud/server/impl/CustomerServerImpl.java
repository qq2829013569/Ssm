package com.cloud.server.impl;

import com.cloud.dao.CustomerDao;
import com.cloud.pojo.CommonResult;
import com.cloud.pojo.Customer;
import com.cloud.pojo.dto.CustomerDto;
import com.cloud.server.CustomerServer;
import com.cloud.uilt.UiliHp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
@Slf4j
public class CustomerServerImpl implements CustomerServer {

    @Resource
    private CustomerDao customerDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public CommonResult setInsert(Customer customer) {
        String account = customer.getCustomerCode();
        String integer1 = customerDao.getSelCode(account);
            if(integer1==null){
                Integer integer2 = customerDao.setInsert(customer);
                log.info("数据插入"+integer2);
                if(integer2 > 0){
                    return new CommonResult(200,"插入成功",integer2);
                }
                return new CommonResult(201,"插入失败",null);
            }
            return new CommonResult(201,"账号已经存在",null);
    }

    @Override
    public CommonResult getIdSelect(CustomerDto customerDto) {
        List list= customerDao.getIdSelect(customerDto);
        if(list.size()==0){
            return new CommonResult(201,"查询失败,用户不存在",null);
        }
        log.info("查询成功"+list);
        return new CommonResult(200,"查询成功",list);
    }

    @Override
    public CommonResult delCunList(List<Integer> listId) {
        if(listId ==null || listId.size()==0){
            return new CommonResult(201,"没有可删除的对象",null);
        }
        Integer integer= customerDao.delCunList(listId);
        if(integer>0){
            return new CommonResult(200,"删除成功,删除数量:",integer);
        }
        return new CommonResult(201,"删除失败",null);
    }

    @Override
    public CommonResult delCusId(Integer customerId) {
        Integer integer = customerDao.delCusId(customerId);
        if(integer > 0){
            return new CommonResult(200,"删除成功",integer);
        }
        return new CommonResult(201,"删除失败",null);
    }

    @Override
    public CommonResult getLoginCus(HttpServletRequest request,HttpServletResponse response,Customer customer) {
        String customerCode = customer.getCustomerCode();
        String customerPaw = customer.getCustomerPaw();
        Customer list = customerDao.getLoginCus(customerCode,customerPaw);
        if(list != null){
                request.getSession().setAttribute("customer",list);
                return new CommonResult(200,"登录成功",list);
            }
            return new CommonResult(201,"登录失败",null);
    }

}
