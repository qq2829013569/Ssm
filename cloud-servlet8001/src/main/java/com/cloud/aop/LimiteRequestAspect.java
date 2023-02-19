package com.cloud.aop;

import com.cloud.pojo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
public class LimiteRequestAspect {

    ConcurrentHashMap<String, ExpiringMap<String,Integer>> boot = new ConcurrentHashMap<>();

//    定义一下切点，带有注解@LimiteRequest都执行切面方法
    @Pointcut("@annotation(limiteRequest)")
    public void exdubServlet (LimiteRequest limiteRequest){
    }
    @Around("exdubServlet(limiteRequest)")
    public Object doAroud(ProceedingJoinPoint pro,LimiteRequest limiteRequest) throws Throwable {
        log.info("开始注入");
        //获取request对象
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        ExpiringMap<String, Integer> uc = boot.getOrDefault(request.getRequestURI(),ExpiringMap.builder().variableExpiration().build());
        Integer uCount = uc.getOrDefault(request.getRemoteAddr(),0);
        if(uCount>=limiteRequest.count()){
            log.error("访问次数上限");
        }else if(uCount==0){
            log.info("次数为0");
            uc.put(request.getRemoteAddr(),uCount+1, ExpirationPolicy.CREATED,limiteRequest.time(), TimeUnit.MILLISECONDS);
        }else {
            log.info("-加1-"+uCount);
            uc.put(request.getRemoteAddr(),uCount+1);
        }
        log.info("---------------");
        boot.put(request.getRequestURI(),uc);
        return pro.proceed();
    }
}
