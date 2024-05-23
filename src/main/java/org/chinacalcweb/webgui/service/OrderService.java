package org.chinacalcweb.webgui.service;

import java.util.List;

import org.chinacalcweb.webgui.model.order.Order;

public interface OrderService {
  
  List<Order> findAll();

  void createOrder(Order order);

  void updateOrder(Order order);

}
