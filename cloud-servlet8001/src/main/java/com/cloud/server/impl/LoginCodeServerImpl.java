package com.cloud.server.impl;

import com.cloud.config.LoginCode;
import com.cloud.pojo.CommonResult;
import com.cloud.server.LoginCodeServer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;

@Service
public class LoginCodeServerImpl implements LoginCodeServer {

    @Resource
    private RedisTemplate<Object, String> redisTemplate;

    @Override
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String id = session.getId();
        System.out.println();
        ResponseCookie cookie = ResponseCookie.from("id",id)
                .secure(true)
                .domain("")
                .path("/")
                .maxAge(Duration.ofHours(1))
                .sameSite("Nane")
                .build();
        if(!String.valueOf(request.getSession().getAttribute("id"+id)).isEmpty()){
            String getVer = String.valueOf(request.getSession().getAttribute("id"+id));
            redisTemplate.delete(getVer);
            System.out.println("清除成功");
        }
        LoginCode loginCode = new LoginCode();
        Object[] verify = loginCode.creteImage();
        session.setAttribute("id"+id,verify[0]);
        System.out.println(verify[0]);
        redisTemplate.opsForValue().set(verify[0],id,5*60);
        BufferedImage bufferedImage = (BufferedImage) verify[1];
        response.setContentType("image/png");
        response.setHeader(HttpHeaders.SET_COOKIE,cookie.toString());
        OutputStream outputStream = response.getOutputStream();
        ImageIO.write(bufferedImage,"png",outputStream);
    }

    @Override
    public CommonResult<String> checkCode(String ver) {
        if(!redisTemplate.hasKey(ver)){
            return new CommonResult<>(201,"验证码错误",null);
        }
        return new CommonResult(200,"验证码成功",ver);
    }
}
