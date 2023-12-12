package org.chinacalcweb.webgui.repo;

import org.chinacalcweb.webgui.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }
