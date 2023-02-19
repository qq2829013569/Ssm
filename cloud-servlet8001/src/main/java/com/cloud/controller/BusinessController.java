package com.cloud.controller;

import com.cloud.pojo.Business;
import com.cloud.pojo.CommonResult;
import com.cloud.pojo.dto.BusinessDto;
import com.cloud.server.BusinessServer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Resource
    private BusinessServer businessServer;

    @GetMapping("/geListBus")
    public CommonResult geListBus(BusinessDto businessDto){
        return businessServer.getListBus(businessDto);
    }

    @PutMapping("/setInsert")
    public CommonResult setInsert(@RequestBody(required = false)Business business){
        return businessServer.setInsert(business);
    }
    @DeleteMapping("/delBusAllId")
    public CommonResult delBusAllId(@RequestParam(required = false)List<Integer> listId){
        return businessServer.delBusAllId(listId);
    }

    @DeleteMapping("/delBusId")
    public CommonResult delBusAllId(Integer bsId){
        return businessServer.delBusId(bsId);
    }

    @PostMapping("/loginBus")
    public CommonResult loginBus(String bsCode,String bsPaw){
        return businessServer.LoginBus(bsCode,bsPaw);
    }
}
