package com.cloud.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessDto {
    private long bsId;
    private String bsCode;
    private String bsPaw;
    private String bsName;
    private String bsSName;
    private String bsArrdes;
    private String bsPhone;
    private String bsHp;
    private long business;
    private Integer pageSize;
    private Integer pageNum;
}
