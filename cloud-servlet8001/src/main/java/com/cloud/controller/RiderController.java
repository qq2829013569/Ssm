package com.cloud.controller;

import com.cloud.pojo.CommonResult;
import com.cloud.pojo.Rider;
import com.cloud.pojo.dto.RiderDto;
import com.cloud.server.RiderServer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rider")
public class RiderController {

    @Resource
    private RiderServer riderServer;

    @PostMapping("/setInsert")
    public CommonResult setInsert(@RequestBody(required = false) Rider rider){
        return riderServer.setInsert(rider);
    }
    @GetMapping("/getListRider")
    public CommonResult getListRider(RiderDto riderDto){
        return riderServer.getListRider(riderDto);
    }
    @PostMapping("/getLogin")
    public CommonResult getLogin(String riderCode,String riderPaw){
        return riderServer.getLogin(riderCode,riderPaw);
    }
    @DeleteMapping("/delListId")
    public CommonResult delListId(@RequestParam(required = false) List<Integer> listId){
        return riderServer.delListId(listId);
    }
    @DeleteMapping("/delRiderId")
    public CommonResult delRiderId(Integer riderId){
        return riderServer.delRiderId(riderId);
    }
}
