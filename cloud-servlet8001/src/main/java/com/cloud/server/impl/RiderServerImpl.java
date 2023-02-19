package com.cloud.server.impl;

import com.cloud.dao.RiderDao;
import com.cloud.pojo.CommonResult;
import com.cloud.pojo.Rider;
import com.cloud.pojo.dto.RiderDto;
import com.cloud.server.RiderServer;
import com.oracle.jrockit.jfr.InstantEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class RiderServerImpl implements RiderServer {

    @Resource
    private RiderDao riderDao;

    @Override
    public CommonResult setInsert(Rider rider) {
        String account = rider.getRiderCode();
        String isAccount = riderDao.getRiderCode(account);
        if(isAccount == null){
            Integer integer = riderDao.setInsert(rider);
            if(rider!=null){
                return new CommonResult(200,"用户注册成功",integer);
            }
            return new CommonResult(201,"注册失败",null);
        }
        return new CommonResult(201,"用户已存在",null);
    }

    @Override
    public CommonResult getListRider(RiderDto riderDto) {
        List<Rider> list = riderDao.getListRider(riderDto);
        if(list.size()!=0){
            return new CommonResult(200,"查询成功",list);
        }
        return new CommonResult(201,"查询失败",null);
    }

    @Override
    public CommonResult getLogin(String riderCode, String riderPaw) {
        Rider rider = riderDao.getLogin(riderCode,riderPaw);
        if(rider != null){
            return new CommonResult(200,"登录成功",rider);
        }
        return new CommonResult(201,"登录失败",null);
    }

    @Override
    public CommonResult delListId(List<Integer> listId) {
        Integer list = riderDao.delListId(listId);
        if(list != 0){
            return new CommonResult(200,"删除成功",list);
        }
        return new CommonResult(201,"删除失败，用户不存在");
    }

    @Override
    public CommonResult delRiderId(Integer riderId) {
        Integer rider = riderDao.delRiderId(riderId);
        if(rider > 0){
            return new CommonResult(200,"删除成功",rider);
        }
        return new CommonResult(201,"删除失败",null);
    }

}
