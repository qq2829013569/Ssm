package com.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

  private long orderId;
  private String orderCode;
  private long orderNum;
  private java.sql.Timestamp orderTime;
  private double orderMoney;
  private long customerId;
  private long riderId;
  private long fId;

}
