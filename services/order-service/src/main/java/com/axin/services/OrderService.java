package com.axin.services;

import com.axin.common.models.CreateOrder;
import com.axin.common.models.CreateOrderBody;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OrderService {
  private static final Map<String, List<CreateOrder>> orderMap = new HashMap<>();

  public CreateOrder createOrder(CreateOrderBody body) {

    int randomPrice = ThreadLocalRandom.current().nextInt(1, 1001);

    CreateOrder createOrder = new CreateOrder();
    createOrder.setUserId(body.getUserId());
    createOrder.setProductId(body.getProductId());
    createOrder.setPrice(randomPrice);
    createOrder.setOrderId(UUID.randomUUID()
            .toString());
    createOrder.setStatus("Success");

    orderMap.computeIfAbsent(body.getUserId(), k -> new ArrayList<>())
            .add(createOrder);

    return createOrder;
  }

  public List<CreateOrder> getOrders(String userId) {
    return orderMap.getOrDefault(userId, new ArrayList<>());
  }
}