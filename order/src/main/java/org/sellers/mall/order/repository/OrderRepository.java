package org.sellers.mall.order.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.sellers.mall.order.repository.entity.Order;
import org.sellers.mall.order.repository.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository extends ServiceImpl<OrderMapper, Order> {
}
