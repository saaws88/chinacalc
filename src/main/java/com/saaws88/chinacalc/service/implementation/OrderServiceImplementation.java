package com.saaws88.chinacalc.service.implementation;

import com.saaws88.chinacalc.domain.model.order.Order;
import com.saaws88.chinacalc.infrastructure.repo.OrderRepository;
import com.saaws88.chinacalc.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImplementation implements OrderService {

  private final OrderRepository repository;

  @Override
  public List<Order> findAll() {
    return repository.findAll();
  }

  @Override
  public void createOrder(Order order) {

    repository.save(order);

  }

}
