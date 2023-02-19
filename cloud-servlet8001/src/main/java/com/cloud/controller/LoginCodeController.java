package com.cloud.controller;

import com.cloud.aop.LimiteRequest;
import com.cloud.pojo.CommonResult;
import com.cloud.server.LoginCodeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/Server")
public class LoginCodeController {

    @Resource
    LoginCodeServer loginCodeServer;

    @LimiteRequest(count = 5)
    @GetMapping("/code1")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        loginCodeServer.createCode(request,response);
    }

    @LimiteRequest(count = 5)
    @GetMapping("code2")
    public CommonResult checkCode(String vel){
        return loginCodeServer.checkCode(vel);
    }
}
