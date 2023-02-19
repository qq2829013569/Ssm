package com.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foods {

  private long fId;
  private String fName;
  private double fPrice;
  private String fType;
  private String fHp;
  private long bsId;


}
