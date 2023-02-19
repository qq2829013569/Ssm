package com.cloud.controller;

import com.cloud.pojo.CommonResult;
import com.cloud.pojo.Customer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/client")
public class ClitenController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/customer/setInsert")
    public CommonResult<Customer> getInfoClient(@RequestBody(required = false) Customer customer){
        return restTemplate.postForObject("http://localhost:8001/customer/setInsert",customer,CommonResult.class);
    }

    @GetMapping("/customer/getIdSelect/{customerId}")
    public CommonResult<Customer> getListCilent(@PathVariable("customerId") Integer customerId){

        return restTemplate.getForObject("http://localhost:8001/customer/getIdSelect/"+customerId,CommonResult.class);
    }

}
