package org.sellers.mall.order.service.impl;

import org.sellers.mall.order.repository.OrderRepository;
import org.sellers.mall.order.repository.entity.Order;
import org.sellers.mall.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository mallOrderRepository;

    @Override
    public List<Order> getOrders() {
        return mallOrderRepository.list();
    }
}
