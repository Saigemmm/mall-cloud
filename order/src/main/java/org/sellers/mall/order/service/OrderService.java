package org.sellers.mall.order.service;

import org.sellers.mall.order.repository.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();
}
