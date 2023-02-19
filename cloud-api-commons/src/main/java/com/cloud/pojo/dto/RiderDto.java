package com.cloud.pojo.dto;

import com.cloud.pojo.Rider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiderDto extends Rider {

    private Integer pageSize;

    private Integer pageNum;
}
