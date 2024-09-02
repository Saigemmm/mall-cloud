package org.sellers.mall.storage.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.sellers.mall.storage.repository.entity.Product;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
