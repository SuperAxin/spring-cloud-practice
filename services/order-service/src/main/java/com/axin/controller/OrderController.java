package com.axin.controller;

import com.axin.common.models.CreateOrder;
import com.axin.common.models.CreateOrderBody;
import com.axin.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/order")
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  // 下訂單
  @PostMapping("/createOrder")
  public CreateOrder createOrder(@RequestBody CreateOrderBody body) {
    return orderService.createOrder(body);
  }

  // 查訂單
  @GetMapping("/getOrder/{userId}")
  public List<CreateOrder> getOrders(@PathVariable String userId) {
    return orderService.getOrders(userId);
  }
}
