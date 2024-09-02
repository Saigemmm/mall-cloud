package org.sellers.mall.order.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.sellers.mall.order.repository.entity.Order;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
