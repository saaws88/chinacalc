package com.saaws88.chinacalc.service.implementation;

import com.saaws88.chinacalc.domain.model.order.Order;
import com.saaws88.chinacalc.infrastructure.repo.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplementationTest {

  @Mock
  OrderRepository repo;
  @InjectMocks
  OrderServiceImplementation service;

  @Test
  @DisplayName("Заказ с валидными данными создается")
  public void createOrder_validData_createsOrder() {

    Order order = new Order();

    service.createOrder(order);

    verify(repo).save(order);

  }

  @Test
  @DisplayName("Поиск всех заказов находит 2 заказа")
  public void findAll_twoOrders_findTwoOrders() {

    List<Order> orderList = new ArrayList<>();
    orderList.add(new Order());
    orderList.add(new Order());

    when(repo.findAll()).thenReturn(orderList);

    assertEquals(orderList.size(), service.findAll().size());

  }

}
