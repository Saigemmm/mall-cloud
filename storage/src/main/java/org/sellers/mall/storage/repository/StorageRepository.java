package org.sellers.mall.storage.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.sellers.mall.storage.repository.entity.Storage;
import org.sellers.mall.storage.repository.mapper.StorageMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StorageRepository extends ServiceImpl<StorageMapper, Storage> {
    public Integer getStorageByProductId(Integer productId) {
        QueryWrapper<Storage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id", productId);
        return this.getOne(queryWrapper).getBalance();
    }
}
