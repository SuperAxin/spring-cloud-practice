package com.axin.common.models;

import lombok.Data;

@Data
public class CreateOrder {
  public String userId;
  public String productId;
  public int price;
  public String orderId;
  public String status;
}
