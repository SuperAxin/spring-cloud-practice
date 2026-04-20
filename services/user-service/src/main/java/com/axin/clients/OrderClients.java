package com.axin.clients;

import com.axin.common.dto.CreateOrderDto;
import com.axin.common.dto.GetOrdersDto;
import com.axin.common.model.CreateOrderBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="order-service")
public interface OrderClients {

  @PostMapping("/order/createOrder")
  CreateOrderDto createOrder(@RequestBody CreateOrderBody body);

  @GetMapping("/order/getOrder/{userId}")
  List<GetOrdersDto> getOrders(@PathVariable("userId") String userId);
}