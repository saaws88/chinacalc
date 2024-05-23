package com.saaws88.chinacalc.repo;

import com.saaws88.chinacalc.domain.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }
