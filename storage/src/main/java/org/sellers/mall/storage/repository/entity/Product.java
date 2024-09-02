package org.sellers.mall.storage.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("mall_product")
@Data
public class Product {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String productName;
    private BigDecimal productPrice;
}
