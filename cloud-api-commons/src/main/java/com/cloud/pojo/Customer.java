package com.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

  private Integer customerId;
  private String customerCode;
  private String customerPaw;
  private String customerName;
  private String customerPhone;
  private String customerAddress;
  private String customerHp;
  private String customerBirthday;

}
