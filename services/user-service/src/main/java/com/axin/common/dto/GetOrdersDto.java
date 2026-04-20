package com.axin.common.dto;

import lombok.Data;

@Data
public class GetOrdersDto {
  public String userId;
  public String productId;
  public int price;
  public String orderId;
  public String status;
}
