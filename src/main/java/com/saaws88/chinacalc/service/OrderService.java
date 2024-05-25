package com.saaws88.chinacalc.service;

import java.util.List;

import com.saaws88.chinacalc.domain.model.order.Order;

public interface OrderService {
  
  List<Order> findAll();

  void createOrder(Order order);

  void updateOrder(Order order);

}
