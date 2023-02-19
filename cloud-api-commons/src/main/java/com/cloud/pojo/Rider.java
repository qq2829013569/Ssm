package com.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rider implements Serializable {

  private long riderId;
  private String riderCode;
  private String riderPaw;
  private String riderName;
  private String riderPhome;
  private String riderHp;
}
