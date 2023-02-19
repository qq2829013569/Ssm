package com.cloud.server;

import cn.hutool.http.server.HttpServerResponse;
import com.cloud.pojo.CommonResult;
import com.cloud.pojo.Customer;
import com.cloud.pojo.dto.CustomerDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CustomerServer {
    CommonResult setInsert(Customer customer);

    CommonResult getIdSelect(CustomerDto customerDto);

    CommonResult delCunList(List<Integer> listId);

    CommonResult delCusId(Integer customerId);

    CommonResult getLoginCus(HttpServletRequest request,HttpServletResponse response,Customer customer);

}
