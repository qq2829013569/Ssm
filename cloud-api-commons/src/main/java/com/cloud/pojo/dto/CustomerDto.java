package com.cloud.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Integer customerId;
    private String customerCode;
    private String customerPaw;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private String customerHp;
    private String customerBirthday;
    private Integer pageSize;
    private Integer pageNum;
}
