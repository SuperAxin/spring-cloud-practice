package com.axin.common.dto;

import lombok.Data;

@Data
public class CreateOrderDto {
  public String userId;
  public String productId;
  public String price;
  public String orderId;
  public String status;
}
