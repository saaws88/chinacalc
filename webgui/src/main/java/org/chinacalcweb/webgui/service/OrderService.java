package org.chinacalcweb.webgui.service;

import java.util.List;

import org.chinacalcweb.webgui.model.Order;

public interface OrderService {
  
  public List<Order> findAll();

  public void createOrder(Order order);

  public void updateOrder(Order order);

}
