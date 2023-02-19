package com.cloud.server.impl;

import com.cloud.dao.BusineDao;
import com.cloud.pojo.Business;
import com.cloud.pojo.CommonResult;
import com.cloud.pojo.dto.BusinessDto;
import com.cloud.pojo.dto.CustomerDto;
import com.cloud.server.BusinessServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@Service
public class BusinessServerImpl implements BusinessServer {

    @Resource
    private BusineDao busineDao;

    @Override
    public CommonResult getListBus(BusinessDto businessDto) {
        List<Business> list = busineDao.getListBus(businessDto);
        if(list!=null){
            return new CommonResult(200,"查询成功",list);
        }
        return new CommonResult(201,"查询失败",null);
    }

    @Override
    public CommonResult setInsert(Business business) {
        String account = business.getBsCode();
        String s = busineDao.getSelCode(account);
        if(s==null){
            Integer integer = busineDao.setInsert(business);
            if(integer>0){
                return new CommonResult(200,"注册成功",integer);
            }
            return new CommonResult(201,"注册失败",null);
        }
        return new CommonResult(201,"商家账号已经存在",null);
    }

    @Transactional
    @Override
    public CommonResult delBusAllId(List<Integer> listId) {
        List<Business> list1 = busineDao.getSelNum(listId);
            if(list1.size()!=0){
                Integer list = busineDao.delBusAllId(listId);
                if(list > 0){
                    return new CommonResult(200,"删除成功:",list1);
                }
            }
            return new CommonResult(201,"删除失败",null);
    }

    @Override
    public CommonResult delBusId(Integer bsId) { ;
           Integer business = busineDao.delBusId(bsId);
           if(business > 0){
               return new CommonResult(200,"删除成功",business);
           }
           return new CommonResult(201,"删除失败",null);
       }

    @Override
    public CommonResult getSelNum(List<Integer> listId) {
        List list = busineDao.getSelNum(listId);
        if(list!=null){
            return new CommonResult(200,"查询成功",list);
        }
        return new CommonResult(200,"查询失败",null);
    }

    @Override
    public CommonResult LoginBus(String bsCode, String bsPaw) {
        Business business = busineDao.LoginBus(bsCode,bsPaw);
        if(business != null){
            return new CommonResult(200,"登录成功",business);
        }
        return new CommonResult(201,"登录失败",null);
    }

}
