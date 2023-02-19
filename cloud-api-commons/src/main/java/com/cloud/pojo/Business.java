package com.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business implements Serializable {

  private long bsId;
  private String bsCode;
  private String bsPaw;
  private String bsName;
  private String bsSName;
  private String bsArrdes;
  private String bsPhone;
  private String bsHp;
  private long business;
}
