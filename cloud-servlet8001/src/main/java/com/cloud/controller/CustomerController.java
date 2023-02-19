package com.cloud.controller;

import com.cloud.aop.LimiteRequest;
import com.cloud.pojo.CommonResult;
import com.cloud.pojo.Customer;
import com.cloud.pojo.dto.CustomerDto;
import com.cloud.server.CustomerServer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerServer customerServer;

    @PutMapping("/setInsert")
    public CommonResult setInsert(@RequestBody(required = false) Customer customer){
        return customerServer.setInsert(customer);
    }

    @GetMapping("/getIdSelect")
    public CommonResult getIdSelect(CustomerDto customerDto){
        return customerServer.getIdSelect(customerDto);
    }

    @DeleteMapping("/delCunList")
    public CommonResult delCunList(@RequestParam(value = "listId",required = false) List<Integer> listId){
        return customerServer.delCunList(listId);
    }
    @DeleteMapping("/delCusId")
    public CommonResult delCusId(Integer customerId){
        return customerServer.delCusId(customerId);
    }

    @PostMapping("/getLoginCus")
    public CommonResult getLoginCus(HttpServletRequest request, HttpServletResponse response,Customer customer){
        return customerServer.getLoginCus(request,response,customer);
    }

}
