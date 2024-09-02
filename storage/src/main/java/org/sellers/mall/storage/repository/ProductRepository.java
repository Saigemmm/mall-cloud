package org.sellers.mall.storage.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.sellers.mall.storage.repository.entity.Product;
import org.sellers.mall.storage.repository.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends ServiceImpl<ProductMapper, Product> {
}

