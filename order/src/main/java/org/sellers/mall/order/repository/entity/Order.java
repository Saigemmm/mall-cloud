package org.sellers.mall.order.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("order")
@Data
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer productId;
    private String orderNo;
    private BigDecimal price;
}
