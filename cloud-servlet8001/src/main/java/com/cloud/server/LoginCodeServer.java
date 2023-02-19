package com.cloud.server;

import com.cloud.pojo.CommonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface LoginCodeServer {

    /**
     * 获取验证码
     * @param request
     * @param response
     * @throws IOException
     */
    void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * 验证码效验
     * @param ver
     * @return
     */
    CommonResult<String> checkCode(String ver);
}
