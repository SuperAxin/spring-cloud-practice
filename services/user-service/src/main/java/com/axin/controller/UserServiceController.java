package com.axin.controller;

import com.axin.clients.OrderClients;
import com.axin.common.dto.CreateOrderDto;
import com.axin.common.dto.GetOrdersDto;
import com.axin.common.model.CreateOrderBody;
import com.axin.common.model.LoginRequest;
import com.axin.common.model.LoginRsp;
import com.axin.common.model.Profile;
import com.axin.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserServiceController {

  private final UserService userService;
  private final OrderClients orderClients;

  public UserServiceController(UserService userService, OrderClients orderClients) {
    this.userService = userService;
    this.orderClients = orderClients;
  }

  @PostMapping("/login")
  public LoginRsp login(@RequestBody LoginRequest body) {
    return userService.login(body);
  }

  @PostMapping("/profile")
  public Profile getProfile(@RequestParam String userName) {
    return userService.getProfile(userName);
  }

  @PostMapping("/createOrder")
  public CreateOrderDto createOrder(@RequestBody CreateOrderBody body) {
    return orderClients.createOrder(body);
  }

  @GetMapping("/health")
  public String health() {
    return "Ok";
  }

  @GetMapping("/getOrders")
  public List<GetOrdersDto> getOrders(@RequestParam String userId) {
    return orderClients.getOrders(userId);
  }
}
